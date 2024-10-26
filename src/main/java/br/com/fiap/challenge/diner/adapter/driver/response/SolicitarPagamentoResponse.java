package br.com.fiap.challenge.diner.adapter.driver.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SolicitarPagamentoResponse {

    private String qrcode;
    private String identificadorPagamento;
}