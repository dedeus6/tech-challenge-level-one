package br.com.fiap.fastfood.adapter.in.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CadastrarEmpresaRequest {

    private String razaoSocial;
    private String nomeFantasia;
    private String cnpj;
}
