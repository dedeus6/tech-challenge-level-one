package br.com.fiap.challenge.diner.adapter.driver.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import static br.com.fiap.challenge.diner.core.application.description.Descriptions.*;
import static br.com.fiap.challenge.diner.core.application.errors.Errors.CAMPO_REQUERIDO;
import static br.com.fiap.challenge.diner.core.application.errors.Errors.LISTA_ITENS_DEVE_TER_UM_ELEMENTO;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CadastrarPedidoRequest {

    @Schema(description = ID_CLIENTE)
    private Long clienteId;

    @Schema(description = ID_EMPRESA)
    @NotNull(message = CAMPO_REQUERIDO)
    private Long empresaId;

    @Schema(description = LISTA_ITENS_PEDIDO)
    @NotNull(message = CAMPO_REQUERIDO)
    @Size(min = 1, message = LISTA_ITENS_DEVE_TER_UM_ELEMENTO)
    private List<ItemRequest> itens;

    @Schema(description = OBSERVACAO)
    private String observacao;
}
