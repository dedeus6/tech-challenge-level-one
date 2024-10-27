package br.com.fiap.challenge.diner.adapter.driver.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static br.com.fiap.challenge.diner.core.application.description.Descriptions.*;
import static br.com.fiap.challenge.diner.core.application.errors.Errors.CAMPO_REQUERIDO;
import static br.com.fiap.challenge.diner.core.application.errors.Errors.VALOR_MAIOR_QUE_0;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemRequest {

    @Schema(description = ID_PRODUTO)
    @NotNull(message = CAMPO_REQUERIDO)
    private Long produtoId;

    @Schema(description = QTD_PRODUTO)
    @NotNull(message = CAMPO_REQUERIDO)
    private Long qtdProduto;

    @Schema(description = VLR_UNITARIO_PRODUTO)
    @Positive(message = VALOR_MAIOR_QUE_0)
    @NotNull(message = CAMPO_REQUERIDO)
    private Double vlrUnitario;
}
