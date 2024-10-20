package br.com.fiap.fastfood.domain.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IncluirEmpresaRequestDTO {

    private Long id;
    private String razaoSocial;
    private String nomeFantasia;
    private String cnpj;
    private String ativo;
}
