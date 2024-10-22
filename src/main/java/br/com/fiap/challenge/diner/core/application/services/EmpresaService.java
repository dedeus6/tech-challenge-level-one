package br.com.fiap.challenge.diner.core.application.services;

import br.com.fiap.challenge.diner.adapter.driven.infra.mappers.EmpresaMapper;
import br.com.fiap.challenge.diner.adapter.driver.exception.BusinessException;
import br.com.fiap.challenge.diner.core.application.dto.EmpresaDTO;
import br.com.fiap.challenge.diner.core.application.ports.EmpresaRepository;
import br.com.fiap.challenge.diner.core.domain.entities.Empresa;
import br.com.fiap.challenge.diner.core.domain.enums.Ativo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static br.com.fiap.challenge.diner.core.application.errors.Errors.EMPRESA_JA_CADASTRADA;

@Service
@RequiredArgsConstructor
public class EmpresaService {

    private final EmpresaRepository empresaRepository;
    private final EmpresaMapper mapper;

    public EmpresaDTO cadastrarEmpresa(EmpresaDTO empresaDTO) {
        Empresa empresa = empresaRepository.findByCnpj(empresaDTO.getCnpj());
        if (Objects.nonNull(empresa))
            throw new BusinessException(EMPRESA_JA_CADASTRADA, HttpStatus.UNPROCESSABLE_ENTITY);

        Empresa entity = mapper.toEntity(empresaDTO);
        entity.setAtivo(Ativo.SIM.getValor());
        Empresa entityResponse = empresaRepository.save(entity);
        return mapper.toDomain(entityResponse);
    }

}
