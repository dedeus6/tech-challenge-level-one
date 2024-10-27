package br.com.fiap.challenge.diner.adapter.driver;

import br.com.fiap.challenge.diner.adapter.driven.infra.mappers.PedidoMapper;
import br.com.fiap.challenge.diner.adapter.driver.request.CadastrarPedidoRequest;
import br.com.fiap.challenge.diner.adapter.driver.response.ErrorResponse;
import br.com.fiap.challenge.diner.adapter.driver.response.PedidoResponse;
import br.com.fiap.challenge.diner.core.application.services.PedidoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static br.com.fiap.challenge.diner.core.application.description.Descriptions.ID;
import static org.springframework.http.HttpStatus.CREATED;

@Validated
@RestController
@RequiredArgsConstructor
@Tag(name = "Pedido")
@ApiResponse(responseCode = "400", description = "Bad Request",
        content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))})
@ApiResponse(responseCode = "422", description = "Unprocessable Entity",
        content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))})
@RequestMapping(value = "/api/v1/pedido")
public class PedidoController {

    private static final String ASC_DESC = "ASC/DESC";

    private final PedidoService service;
    private final PedidoMapper mapper;

    @Operation(summary = "Realizar Pedido")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Pedido realizado com sucesso",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = PedidoResponse.class))})})
    @PostMapping
    public ResponseEntity<PedidoResponse> cadastrarPedido(
            @RequestBody @Valid CadastrarPedidoRequest request) {
        var requestDTO = mapper.toPedidoDTO(request);
        return ResponseEntity
                .status(CREATED)
                .body(service.cadastrarPedido(requestDTO));
    }

    @Operation(summary = "Buscar pedido")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = PedidoResponse.class))})})
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPedido(
            @Parameter(description = ID)
            @PathVariable(name = "id")
            final Long id) {
        var response = service.buscarPedidoPorId(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Operation(summary = "Atualiza status do pedido")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Atualização realizada com sucesso",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = PedidoResponse.class))})})
    @PatchMapping("/status/{id}")
    public ResponseEntity<?> atualizaStatusPedido(
            @Parameter(description = ID)
            @PathVariable(name = "id")
            final Long id) {
        var response = service.atualizaStatusPedido(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
