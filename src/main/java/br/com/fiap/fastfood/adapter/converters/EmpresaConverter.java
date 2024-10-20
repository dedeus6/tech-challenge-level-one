package br.com.fiap.fastfood.adapter.converters;

import br.com.fiap.fastfood.domain.domain.dto.IncluirEmpresaRequestDTO;
import br.com.fiap.fastfood.domain.domain.model.Empresa;
import br.com.fiap.fastfood.adapter.inbound.controller.request.IncluirEmpresaRequest;
import br.com.fiap.fastfood.adapter.inbound.controller.response.EmpresaResponse;

public class EmpresaConverter {

    public static EmpresaResponse convertToEmpresaResponse(Empresa empresa) {
        return EmpresaResponse.builder()
                .id(empresa.getId())
                .razaoSocial(empresa.getRazaoSocial())
                .nomeFantasia(empresa.getNomeFantasia())
                .cnpj(empresa.getCnpj())
                .ativo(empresa.getAtivo())
                .build();
    }

    public static IncluirEmpresaRequestDTO convertToIncluirEmpresaRequestDTO(IncluirEmpresaRequest request) {
        return IncluirEmpresaRequestDTO.builder()
                .razaoSocial(request.getRazaoSocial())
                .nomeFantasia(request.getNomeFantasia())
                .cnpj(request.getCnpj())
                .build();
    }

    public static Empresa convertToEmpresa(IncluirEmpresaRequestDTO request) {
        return Empresa.builder()
                .razaoSocial(request.getRazaoSocial())
                .nomeFantasia(request.getNomeFantasia())
                .cnpj(request.getCnpj())
                .ativo(request.getAtivo())
                .build();
    }
}
