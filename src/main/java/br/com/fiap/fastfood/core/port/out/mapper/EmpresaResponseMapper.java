package br.com.fiap.fastfood.core.port.out.mapper;

import br.com.fiap.fastfood.core.port.in.mapper.EmpresaRequestMapper;
import br.com.fiap.fastfood.core.port.out.response.EmpresaResponse;
import br.com.fiap.fastfood.domain.domain.EmpresaDomain;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EmpresaResponseMapper {

    EmpresaResponseMapper INSTANCE = Mappers.getMapper(EmpresaResponseMapper.class);

    EmpresaResponse toEmpresaResponse(EmpresaDomain domain);
}
