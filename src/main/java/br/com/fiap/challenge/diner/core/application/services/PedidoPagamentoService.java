package br.com.fiap.challenge.diner.core.application.services;

import br.com.fiap.challenge.diner.adapter.driven.infra.mappers.PedidoMapper;
import br.com.fiap.challenge.diner.adapter.driver.exception.BusinessException;
import br.com.fiap.challenge.diner.adapter.driver.response.SolicitarPagamentoResponse;
import br.com.fiap.challenge.diner.core.application.ports.FormaPagamentoRepository;
import br.com.fiap.challenge.diner.core.application.ports.PedidoPagamentoRepository;
import br.com.fiap.challenge.diner.core.application.ports.PedidoRepository;
import br.com.fiap.challenge.diner.core.application.services.pagamentos.MercadoPagoService;
import br.com.fiap.challenge.diner.core.application.utils.Numbers;
import br.com.fiap.challenge.diner.core.application.utils.Strings;
import br.com.fiap.challenge.diner.core.domain.dto.SolicitarPagamentoDTO;
import br.com.fiap.challenge.diner.core.domain.entities.FormaPagamento;
import br.com.fiap.challenge.diner.core.domain.entities.Pedido;
import br.com.fiap.challenge.diner.core.domain.entities.PedidoPagamento;
import br.com.fiap.challenge.diner.core.domain.enums.StatusPedido;
import br.com.fiap.challenge.diner.core.domain.enums.StatusPedidoPagamento;
import br.com.fiap.challenge.diner.core.domain.enums.TipoPagamento;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;

import static br.com.fiap.challenge.diner.core.application.errors.Errors.FORMA_PAGAMENTO_NAO_DISPONIVEL;
import static br.com.fiap.challenge.diner.core.application.errors.Errors.FORMA_PAGAMENTO_NAO_ENCONTRADO;
import static br.com.fiap.challenge.diner.core.application.errors.Errors.PEDIDO_NAO_ENCONTRADO;
import static br.com.fiap.challenge.diner.core.application.errors.Errors.PEDIDO_STATUS_DIFERENTE_RECEBIDO;
import static br.com.fiap.challenge.diner.core.application.errors.Errors.PEDIDO_VALOR_TOTAL_ZERO;
import static br.com.fiap.challenge.diner.core.domain.enums.StatusPedido.RECEBIDO;
import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;

@Service
@RequiredArgsConstructor
public class PedidoPagamentoService {

    private final PedidoMapper pedidoMapper;
    private final PedidoRepository pedidoRepository;
    private final PedidoPagamentoRepository pedidoPagamentoRepository;
    private final FormaPagamentoRepository formaPagamentoRepository;
    private final MercadoPagoService mercadoPagoService;

    public SolicitarPagamentoResponse solicitarPagamento(SolicitarPagamentoDTO requestDTO) {
        var pedido = this.getPedido(requestDTO.getPedidoId());
        if (Numbers.isEmpty(pedido.getVlrTotal()))
            throw new BusinessException(PEDIDO_VALOR_TOTAL_ZERO, UNPROCESSABLE_ENTITY);
        if (Strings.diff(pedido.getStatus(), RECEBIDO.getValor()))
            throw new BusinessException(PEDIDO_STATUS_DIFERENTE_RECEBIDO, UNPROCESSABLE_ENTITY);

        var formaPagamento = this.getFormaPagamento(requestDTO.getFormaPagamentoId());
        var solicitacaoPagamento = solicitarPagamento(formaPagamento.getTipoPagamento(), pedido.getVlrTotal());
        pedidoPagamentoRepository.save(getPedidoPagamento(formaPagamento, pedido, solicitacaoPagamento));

        threadSimuladorPagamento(requestDTO);
        return solicitacaoPagamento;
    }

    private static PedidoPagamento getPedidoPagamento(FormaPagamento formaPagamento, Pedido pedido, SolicitarPagamentoResponse solicitacaoPagamento) {
        PedidoPagamento pedidoPagamento = PedidoPagamento.builder()
                .formaPagamento(formaPagamento)
                .pedido(pedido)
                .vlrPagamento(pedido.getVlrTotal())
                .status(StatusPedidoPagamento.PENDENTE.getValor())
                .identificadorPagamento(solicitacaoPagamento.getIdentificadorPagamento())
                .build();
        return pedidoPagamento;
    }

    private void threadSimuladorPagamento(SolicitarPagamentoDTO requestDTO) {
        Runnable task = () -> {
            var pedido = pedidoRepository.findById(requestDTO.getPedidoId()).orElse(null);
            if (pedido == null)
                return;

            try {
                Thread.sleep(Duration.ofSeconds(5));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            pedido.getPagamentos().forEach(i -> i.setStatus(StatusPedidoPagamento.CONFIRMADO.getValor()));
            pedido.setStatus(StatusPedido.EM_PREPARACAO.getValor());
            pedidoRepository.save(pedido);
        };

        Thread thread = new Thread(task);
        thread.start();
    }

    private SolicitarPagamentoResponse solicitarPagamento(String tipoPagamento, Double vlrPagamento) {
        var value = TipoPagamento.valueOf(tipoPagamento);
        return switch (value) {
            case TipoPagamento.PIX -> mercadoPagoService.solicitarPagamentoPix(vlrPagamento);
            default -> throw new BusinessException(FORMA_PAGAMENTO_NAO_DISPONIVEL, UNPROCESSABLE_ENTITY);
        };
    }

    private Pedido getPedido(Long pedidoId) {
        return pedidoRepository.findById(pedidoId)
                .orElseThrow(() -> new BusinessException(PEDIDO_NAO_ENCONTRADO, UNPROCESSABLE_ENTITY));
    }

    private FormaPagamento getFormaPagamento(Long formaPagamentoId) {
        return formaPagamentoRepository.findById(formaPagamentoId)
                .orElseThrow(() -> new BusinessException(FORMA_PAGAMENTO_NAO_ENCONTRADO, UNPROCESSABLE_ENTITY));
    }

}
