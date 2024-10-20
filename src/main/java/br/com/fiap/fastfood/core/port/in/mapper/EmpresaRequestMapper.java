package br.com.fiap.fastfood.core.port.in.mapper;

import br.com.fiap.fastfood.adapter.in.request.CadastrarEmpresaRequest;
import br.com.fiap.fastfood.domain.domain.EmpresaDomain;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EmpresaRequestMapper {

    EmpresaRequestMapper INSTANCE = Mappers.getMapper(EmpresaRequestMapper.class);

    EmpresaDomain toEmpresa(CadastrarEmpresaRequest request);
}
