package br.com.fiap.challenge.diner.adapter.driver.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static br.com.fiap.challenge.diner.core.application.errors.Errors.CAMPO_REQUERIDO;
import static br.com.fiap.challenge.diner.core.application.errors.Errors.CNPJ_INVALIDO;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CadastrarEmpresaRequest {

    @NotBlank(message = CAMPO_REQUERIDO)
    private String razaoSocial;
    @NotBlank(message = CAMPO_REQUERIDO)
    private String nomeFantasia;
    @NotBlank(message = CAMPO_REQUERIDO)
    @Size(min = 14, max = 14, message = CNPJ_INVALIDO)
    private String cnpj;
}
