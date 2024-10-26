package br.com.fiap.challenge.diner.adapter.driver.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import static br.com.fiap.challenge.diner.core.application.description.Descriptions.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CadastrarPedidoRequest {

    @Schema(description = ID_CLIENTE)
    private Long clienteId;

    @Schema(description = ID_EMPRESA)
    private Long empresaId;

    @Schema(description = LISTA_ITENS_PEDIDO)
    private List<ItemRequest> itens;

    @Schema(description = OBSERVACAO)
    private String observacao;

}
