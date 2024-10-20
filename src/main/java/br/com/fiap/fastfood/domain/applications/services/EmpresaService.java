package br.com.fiap.fastfood.domain.applications.services;

import br.com.fiap.fastfood.domain.applications.enums.Ativo;
import br.com.fiap.fastfood.config.exception.BusinessException;
import br.com.fiap.fastfood.domain.applications.ports.EmpresaRepository;
import br.com.fiap.fastfood.domain.domain.dto.IncluirEmpresaRequestDTO;
import br.com.fiap.fastfood.domain.domain.model.Empresa;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import static br.com.fiap.fastfood.adapter.converters.EmpresaConverter.convertToEmpresa;
import static java.util.Objects.nonNull;

@Service
@RequiredArgsConstructor
public class EmpresaService {

    private final EmpresaRepository empresaRepository;

    public Empresa incluirEmpresa(IncluirEmpresaRequestDTO request) {
        var empresa = empresaRepository.findByCnpj(request.getCnpj());
        if (nonNull(empresa)) {
            throw new BusinessException("sim", HttpStatus.UNPROCESSABLE_ENTITY);
        }

        empresa = convertToEmpresa(request);
        empresa.setAtivo(Ativo.SIM.getValor());
        return empresaRepository.save(empresa);
    }
}
