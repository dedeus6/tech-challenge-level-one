package br.com.fiap.fastfood.adapter.out.persistence.adapter.impl;

import br.com.fiap.fastfood.adapter.out.persistence.adapter.EmpresaPersistenceAdapter;
import br.com.fiap.fastfood.adapter.out.persistence.entity.Empresa;
import br.com.fiap.fastfood.adapter.out.persistence.mapper.EmpresaPersistenceMapper;
import br.com.fiap.fastfood.adapter.out.persistence.repository.EmpresaRepository;
import br.com.fiap.fastfood.core.port.out.exception.BusinessException;
import br.com.fiap.fastfood.domain.domain.EmpresaDomain;
import br.com.fiap.fastfood.domain.enums.Ativo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class EmpresaPersistenceAdapterImpl implements EmpresaPersistenceAdapter {

    private final EmpresaRepository empresaRepository;
    private final EmpresaPersistenceMapper persistenceMapper;

    @Override
    public EmpresaDomain cadastrarEmpresa(EmpresaDomain empresaDomain) {
        Empresa empresa = empresaRepository.findByCnpj(empresaDomain.getCnpj());
        if (Objects.nonNull(empresa))
            throw new BusinessException("Empresa já está cadastrada", HttpStatus.UNPROCESSABLE_ENTITY);

        Empresa entity = persistenceMapper.toEntity(empresaDomain);
        entity.setAtivo(Ativo.SIM.getValor());
        Empresa entityResponse = empresaRepository.save(entity);
        return persistenceMapper.toDomain(entityResponse);
    }
}
