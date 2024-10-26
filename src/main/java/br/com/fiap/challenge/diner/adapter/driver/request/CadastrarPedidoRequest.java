package br.com.fiap.challenge.diner.adapter.driver.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CadastrarPedidoRequest {

    private Long clienteId;
    private Long empresaId;
    private List<ItemRequest> itens;
    private String observacao;

}
