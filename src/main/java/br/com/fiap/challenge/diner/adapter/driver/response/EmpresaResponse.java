package br.com.fiap.challenge.diner.adapter.driver.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class EmpresaResponse {

    private Long id;
    private String razaoSocial;
    private String nomeFantasia;
    private String cnpj;
    private String ativo;
}
