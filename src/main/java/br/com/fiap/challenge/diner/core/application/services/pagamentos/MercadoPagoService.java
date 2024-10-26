package br.com.fiap.challenge.diner.core.application.services.pagamentos;

import br.com.fiap.challenge.diner.adapter.driver.response.SolicitarPagamentoResponse;
import br.com.fiap.challenge.diner.core.domain.enums.TipoPagamento;
import br.com.fiap.fastfood.adapter.integration.MercadoPagoIntegration;
import br.com.fiap.fastfood.adapter.request.OrderPaymentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MercadoPagoService {

    private final MercadoPagoIntegration mercadoPagoIntegration;

    public SolicitarPagamentoResponse solicitarPagamentoPix(Double vlrPagamento) {
        var request = OrderPaymentRequest.builder()
                .type(TipoPagamento.PIX.name())
                .amount(vlrPagamento)
                .build();

        var orderPayment = mercadoPagoIntegration.orderPayment(request);
        return SolicitarPagamentoResponse.builder()
                .qrcode(orderPayment.getQrcode())
                .identificadorPagamento(orderPayment.getPaymentId())
                .build();
    }
}
