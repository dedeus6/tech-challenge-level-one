package br.com.fiap.challenge.diner.adapter.driver.request;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

import static br.com.fiap.challenge.diner.core.application.errors.Errors.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CadastrarProdutoRequest {

    @NotBlank(message = DESCRICAO_REQUERIDO)
    private String descricao;

    @NotNull(message = VLR_UNITARIO_REQUERIDO)
    @Digits(integer = 10, fraction = 2, message = VLR_UNITARIO_FORMATO_INVALIDO)
    private BigDecimal vlrUnitario;

    @NotNull(message = CATEGORIA_ID_REQUERIDO)
    private Long categoriaId;

}
