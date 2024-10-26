package br.com.fiap.challenge.diner.adapter.driver;

import br.com.fiap.challenge.diner.adapter.driven.infra.mappers.PedidoPagamentoMapper;
import br.com.fiap.challenge.diner.adapter.driver.request.SolicitarPagamentoRequest;
import br.com.fiap.challenge.diner.adapter.driver.response.CategoriaResponse;
import br.com.fiap.challenge.diner.adapter.driver.response.ErrorResponse;
import br.com.fiap.challenge.diner.core.application.services.PedidoPagamentoService;
import br.com.fiap.fastfood.adapter.integration.MercadoPagoIntegration;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;

@Validated
@RestController
@RequiredArgsConstructor
@Tag(name = "Pedido Pagamento")
@ApiResponse(responseCode = "400", description = "Bad Request",
        content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))})
@ApiResponse(responseCode = "422", description = "Unprocessable Entity",
        content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))})
@RequestMapping(value = "/api/v1/pedido-pagamento")
public class PedidoPagamentoController {

    private final PedidoPagamentoService service;
    private final PedidoPagamentoMapper mapper;
    private final MercadoPagoIntegration integration;

    @Operation(summary = "Solicitação de pagamento")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Solicitação de pagamento realizado com sucesso",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = CategoriaResponse.class))})})
    @PostMapping("/solicitar")
    public ResponseEntity<CategoriaResponse> solicitarPagamento(
            @RequestBody @Valid SolicitarPagamentoRequest request) {
        var requestDTO = mapper.toPedidoPagamentoDTO(request);
        var response = service.solicitarPagamento(requestDTO);
        return ResponseEntity.status(CREATED).build();
    }
}
