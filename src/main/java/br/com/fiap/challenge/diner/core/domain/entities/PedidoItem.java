package br.com.fiap.challenge.diner.core.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pedido_item")
public class PedidoItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;
    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;
    @Column(name = "qtd_produto")
    private Long qtdProduto;
    @Column(name = "vlr_unitario")
    private Double vlrUnitario = 0.0;
    @Column(name = "vlr_desconto")
    private Double vlrDesconto = 0.0;
    @Column(name = "vlr_bruto")
    private Double vlrBruto = 0.0;
    @Column(name = "vlr_liquido")
    private Double vlrLiquido = 0.0;
    private String observacao;
}
