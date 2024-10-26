package br.com.fiap.challenge.diner.core.domain.dto;

import br.com.fiap.challenge.diner.adapter.driver.request.ItemRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PedidoDTO {

    private Long id;
    private Long clienteId;
    private Long empresaId;
    private String status;
    private LocalDateTime data;
    private List<ItemRequest> itens;
    private String observacao;

}
