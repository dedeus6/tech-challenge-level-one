package br.com.fiap.challenge.diner.core.domain.dto;

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
    @Builder.Default
    private String status = "RECEBIDO";
    private LocalDateTime data;
    private List<ItemDTO> itens;
    private String observacao;

}
