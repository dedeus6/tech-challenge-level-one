package br.com.fiap.challenge.diner.adapter.driver.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static br.com.fiap.challenge.diner.core.application.errors.Errors.CAMPO_REQUERIDO;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SolicitarPagamentoRequest {

    @NotNull(message = CAMPO_REQUERIDO)
    private Long formaPagamentoId;
    @NotNull(message = CAMPO_REQUERIDO)
    private Long pedidoId;
}
