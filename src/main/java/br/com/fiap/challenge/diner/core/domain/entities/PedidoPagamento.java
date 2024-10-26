package br.com.fiap.challenge.diner.core.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pedido_pagamento")
public class PedidoPagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "forma_pagamento_id")
    private FormaPagamento formaPagamento;
    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;
    @Column(name = "vlr_pagamento")
    private Double vlrPagamento = 0.0;
    private String status;
    private String identificadorPagamento;
}
