package br.com.fiap.fastfood.adapter.inbound.controller.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IncluirEmpresaRequest {

    private String razaoSocial;
    private String nomeFantasia;
    private String cnpj;
}
