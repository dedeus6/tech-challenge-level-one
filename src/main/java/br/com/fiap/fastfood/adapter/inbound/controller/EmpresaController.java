package br.com.fiap.fastfood.adapter.inbound.controller;

import br.com.fiap.fastfood.domain.applications.services.EmpresaService;
import br.com.fiap.fastfood.adapter.inbound.controller.request.IncluirEmpresaRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static br.com.fiap.fastfood.adapter.converters.EmpresaConverter.convertToEmpresaResponse;
import static br.com.fiap.fastfood.adapter.converters.EmpresaConverter.convertToIncluirEmpresaRequestDTO;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/empresa")
public class EmpresaController {

    private final EmpresaService service;

    @PostMapping
    public ResponseEntity<?> incluirEmpresa(@RequestBody IncluirEmpresaRequest request) {
        var empresaDTO = convertToIncluirEmpresaRequestDTO(request);
        var empresa = service.incluirEmpresa(empresaDTO);
        return new ResponseEntity<>(convertToEmpresaResponse(empresa), HttpStatus.OK);
    }
}
