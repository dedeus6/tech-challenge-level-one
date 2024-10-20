package br.com.fiap.fastfood.adapter.out.persistence.mapper;

import br.com.fiap.fastfood.adapter.out.persistence.entity.Empresa;
import br.com.fiap.fastfood.core.port.out.mapper.EmpresaResponseMapper;
import br.com.fiap.fastfood.domain.domain.EmpresaDomain;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EmpresaPersistenceMapper {

    EmpresaPersistenceMapper INSTANCE = Mappers.getMapper(EmpresaPersistenceMapper.class);

    Empresa toEntity(EmpresaDomain empresaDomain);

    EmpresaDomain toDomain(Empresa empresa);
}
