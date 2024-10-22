package br.com.fiap.challenge.diner.adapter.driven.infra.mappers;

import br.com.fiap.challenge.diner.adapter.driver.request.CadastrarEmpresaRequest;
import br.com.fiap.challenge.diner.adapter.driver.response.EmpresaResponse;
import br.com.fiap.challenge.diner.core.application.dto.EmpresaDTO;
import br.com.fiap.challenge.diner.core.domain.entities.Empresa;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EmpresaMapper {

    EmpresaMapper INSTANCE = Mappers.getMapper(EmpresaMapper.class);

    EmpresaDTO toEmpresa(CadastrarEmpresaRequest request);
    Empresa toEntity(EmpresaDTO empresaDomain);
    EmpresaDTO toDomain(Empresa empresa);
    EmpresaResponse toEmpresaResponse(EmpresaDTO domain);
}
