package br.com.fiap.fastfood.adapter.in.controller;

import br.com.fiap.fastfood.adapter.in.request.CadastrarEmpresaRequest;
import br.com.fiap.fastfood.core.port.processor.EmpresaProcessor;
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

    private final EmpresaProcessor processor;

    @PostMapping
    public ResponseEntity<?> cadastrarEmpresa(@RequestBody CadastrarEmpresaRequest request) {
        var response = processor.cadastrarEmpresa(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
