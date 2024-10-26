package br.com.fiap.challenge.diner.core.application.services;

import br.com.fiap.challenge.diner.adapter.driven.infra.mappers.PedidoMapper;
import br.com.fiap.challenge.diner.adapter.driver.exception.BusinessException;
import br.com.fiap.challenge.diner.adapter.driver.response.PedidoResponse;
import br.com.fiap.challenge.diner.core.application.ports.ClienteRepository;
import br.com.fiap.challenge.diner.core.application.ports.EmpresaRepository;
import br.com.fiap.challenge.diner.core.application.ports.PedidoItemRepository;
import br.com.fiap.challenge.diner.core.application.ports.PedidoRepository;
import br.com.fiap.challenge.diner.core.application.ports.ProdutoRepository;
import br.com.fiap.challenge.diner.core.domain.dto.ItemDTO;
import br.com.fiap.challenge.diner.core.domain.dto.PedidoDTO;
import br.com.fiap.challenge.diner.core.domain.entities.Cliente;
import br.com.fiap.challenge.diner.core.domain.entities.Empresa;
import br.com.fiap.challenge.diner.core.domain.entities.Pedido;
import br.com.fiap.challenge.diner.core.domain.entities.Produto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static br.com.fiap.challenge.diner.core.application.errors.Errors.CLIENTE_NAO_ENCONTRADO;
import static br.com.fiap.challenge.diner.core.application.errors.Errors.EMPRESA_NAO_ENCONTRADA;
import static br.com.fiap.challenge.diner.core.application.errors.Errors.PRODUTO_NAO_ENCONTRADO;
import static br.com.fiap.challenge.diner.core.application.utils.Numbers.isEmpty;
import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;

@Service
@RequiredArgsConstructor
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final PedidoItemRepository pedidoItemRepository;
    private final ProdutoRepository produtoRepository;
    private final EmpresaRepository empresaRepository;
    private final ClienteRepository clienteRepository;

    private final PedidoMapper pedidoMapper;

    public PedidoResponse cadastrarPedido(PedidoDTO pedidoDTO) {
        var empresa = getEmpresa(pedidoDTO.getEmpresaId());
        var cliente = isEmpty(pedidoDTO.getClienteId()) ? getCliente(pedidoDTO.getClienteId()) : null;

        var pedido = pedidoMapper.toPedidoEntidade(pedidoDTO);
        pedido.setEmpresa(empresa);
        pedido.setCliente(cliente);

        getItensPedido(pedidoDTO.getItens(), pedido);
        pedido.calculaVlrTotal();

        var pedidoResponse = pedidoRepository.save(pedido);

        return pedidoMapper.toPedidoResponse(pedidoResponse);
    }

    private void getItensPedido(List<ItemDTO> itens, Pedido pedido) {
        itens.forEach(item -> {
            var produto = getProduto(item.getProdutoId());
            var itemPedido = pedido.addItem();
            itemPedido.setProduto(produto);
            itemPedido.setQtdProduto(item.getQtdProduto());
            itemPedido.setVlrUnitario(item.getVlrUnitario());
        });
    }

    private Produto getProduto(Long id) {
        return produtoRepository.findById(id)
                .orElseThrow(() -> new BusinessException(PRODUTO_NAO_ENCONTRADO, UNPROCESSABLE_ENTITY));
    }

    private Empresa getEmpresa(Long id) {
        return empresaRepository.findById(id)
                .orElseThrow(() -> new BusinessException(EMPRESA_NAO_ENCONTRADA, UNPROCESSABLE_ENTITY));
    }

    private Cliente getCliente(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new BusinessException(CLIENTE_NAO_ENCONTRADO, UNPROCESSABLE_ENTITY));
    }
}
