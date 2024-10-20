package br.com.fiap.fastfood.core.port.processor;

import br.com.fiap.fastfood.adapter.in.request.CadastrarEmpresaRequest;
import br.com.fiap.fastfood.core.port.in.mapper.EmpresaRequestMapper;
import br.com.fiap.fastfood.core.port.out.mapper.EmpresaResponseMapper;
import br.com.fiap.fastfood.core.port.out.response.EmpresaResponse;
import br.com.fiap.fastfood.core.service.EmpresaService;
import br.com.fiap.fastfood.domain.domain.EmpresaDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmpresaProcessor {

    private final EmpresaService empresaService;
    private final EmpresaRequestMapper requestMapper;
    private final EmpresaResponseMapper responseMapper;

    public EmpresaResponse cadastrarEmpresa(CadastrarEmpresaRequest request) {
        EmpresaDomain domain = empresaService.cadastrarEmpresa(requestMapper.toEmpresa(request));
        return responseMapper.toEmpresaResponse(domain);
    }
}
