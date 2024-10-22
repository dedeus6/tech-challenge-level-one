package br.com.fiap.challenge.diner.adapter.driver;

import br.com.fiap.challenge.diner.adapter.driven.infra.mappers.EmpresaMapper;
import br.com.fiap.challenge.diner.adapter.driver.request.CadastrarEmpresaRequest;
import br.com.fiap.challenge.diner.core.application.services.EmpresaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/empresa")
public class EmpresaController {

    private final EmpresaService service;
    private final EmpresaMapper mapper;

    @PostMapping
    public ResponseEntity<?> cadastrarEmpresa(@RequestBody @Valid CadastrarEmpresaRequest request) {
        var response = service.cadastrarEmpresa(mapper.toEmpresa(request));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
