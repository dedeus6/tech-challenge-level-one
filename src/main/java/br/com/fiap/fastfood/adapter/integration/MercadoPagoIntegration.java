package br.com.fiap.fastfood.adapter.integration;

import br.com.fiap.fastfood.adapter.request.OrderPaymentRequest;
import br.com.fiap.fastfood.adapter.response.OrderPaymentResponse;
import br.com.fiap.fastfood.core.configuration.ErrorDecoderConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "mercado-pago", url = "https://run.mocky.io/v3", configuration = ErrorDecoderConfig.class)
public interface MercadoPagoIntegration {

    @PostMapping("/9e91474c-fd0f-42a5-b098-e6bb04f0a0d9")
    OrderPaymentResponse orderPayment(OrderPaymentRequest request);
}
