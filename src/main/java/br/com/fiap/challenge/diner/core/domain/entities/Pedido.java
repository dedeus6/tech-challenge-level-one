package br.com.fiap.challenge.diner.core.domain.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;
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
    private String status;
    @OrderBy("id")
    @Fetch(FetchMode.SELECT)
    @OneToMany(mappedBy = "pedido", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<PedidoPagamento> pagamentos = new ArrayList<>();
    @OrderBy("id")
    @Fetch(FetchMode.SELECT)
    @OneToMany(mappedBy = "pedido", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<PedidoItem> itens = new ArrayList<>();

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
}
