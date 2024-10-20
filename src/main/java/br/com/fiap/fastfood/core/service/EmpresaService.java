package br.com.fiap.fastfood.core.service;

import br.com.fiap.fastfood.adapter.out.persistence.adapter.EmpresaPersistenceAdapter;
import br.com.fiap.fastfood.domain.domain.EmpresaDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmpresaService {

    @Autowired
    private EmpresaPersistenceAdapter empresaAdapter;

    public EmpresaDomain cadastrarEmpresa(EmpresaDomain empresaDomain) {
        return empresaAdapter.cadastrarEmpresa(empresaDomain);
    }
}
