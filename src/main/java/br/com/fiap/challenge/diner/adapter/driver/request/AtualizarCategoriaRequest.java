package br.com.fiap.challenge.diner.adapter.driver.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static br.com.fiap.challenge.diner.core.application.description.Descriptions.DESCRICAO_CATEGORIA;
import static br.com.fiap.challenge.diner.core.application.errors.Errors.DESCRICAO_REQUERIDO;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AtualizarCategoriaRequest {

    @Schema(description = DESCRICAO_CATEGORIA)
    @NotBlank(message = DESCRICAO_REQUERIDO)
    private String descricao;

}
