package br.com.fiap.fastfood.domain.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmpresaDomain {

    private Long id;
    private String razaoSocial;
    private String nomeFantasia;
    private String cnpj;
    private String ativo;
}
