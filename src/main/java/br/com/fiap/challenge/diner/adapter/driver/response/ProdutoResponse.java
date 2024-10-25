package br.com.fiap.challenge.diner.adapter.driver.response;

import br.com.fiap.challenge.diner.core.domain.entities.Categoria;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

import static br.com.fiap.challenge.diner.core.application.description.Descriptions.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class ProdutoResponse {

    @Schema(description = ID)
    private Integer id;

    @Schema(description = DESCRICAO_PRODUTO)
    private String descricao;

    @Schema(description = VLR_UNITARIO_PRODUTO)
    private BigDecimal vlrUnitario;

    @Schema(description = CATEGORIA_PRODUTO)
    private CategoriaResponse categoria;

}
