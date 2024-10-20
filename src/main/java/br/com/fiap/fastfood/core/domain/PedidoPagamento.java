package br.com.fiap.fastfood.core.domain;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
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
    private Pedido pedido;
    @Column(name = "vlr_pagamento")
    private Double vlrPagamento = 0.0;
    private String confirmado;
    private String observacao;
}
