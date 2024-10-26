package br.com.fiap.challenge.diner.core.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime data;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @Builder.Default
    @Column(name = "vlr_total")
    private Double vlrTotal = 0.0;

    private String status;

    @OrderBy("id")
    @Fetch(FetchMode.SELECT)
    @OneToMany(mappedBy = "pedido", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<PedidoPagamento> pagamentos = new ArrayList<>();

    @Builder.Default
    @OrderBy("id")
    @Fetch(FetchMode.SELECT)
    @OneToMany(mappedBy = "pedido", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<PedidoItem> itens = new ArrayList<>();

    private String observacao;

    public PedidoItem addItem() {
        PedidoItem item = new PedidoItem();
        item.setPedido(this);
        itens.add(item);
        return item;
    }

    public PedidoPagamento addPagamento() {
        PedidoPagamento item = new PedidoPagamento();
        item.setPedido(this);
        pagamentos.add(item);
        return item;
    }

    public Double calculaVlrTotal() {
        this.vlrTotal = this.itens.stream()
                .mapToDouble(item -> item.getVlrUnitario() * item.getQtdProduto())
                .sum();
        return this.vlrTotal;
    }
}
