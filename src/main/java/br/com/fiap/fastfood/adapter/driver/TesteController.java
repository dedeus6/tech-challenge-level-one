package br.com.fiap.fastfood.adapter.driver;

import br.com.fiap.fastfood.core.applications.services.TesteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/teste")
public class TesteController {

    private final TesteService service;

    @GetMapping
    public ResponseEntity<?> getTeste() {
        return new ResponseEntity<>("ok", HttpStatus.OK);
    }
}
