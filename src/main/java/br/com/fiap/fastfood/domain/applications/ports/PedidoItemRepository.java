package br.com.fiap.fastfood.domain.applications.ports;

import br.com.fiap.fastfood.domain.domain.model.PedidoItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoItemRepository extends JpaRepository<PedidoItem, Long> {
}
