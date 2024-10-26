package br.com.fiap.challenge.diner.adapter.driver.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static br.com.fiap.challenge.diner.core.application.description.Descriptions.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemRequest {

    @Schema(description = ID_PRODUTO)
    private Long produtoId;

    @Schema(description = QTD_PRODUTO)
    private Long qtdProduto;

    @Schema(description = VLR_UNITARIO_PRODUTO)
    private Double vlrUnitario;
}
