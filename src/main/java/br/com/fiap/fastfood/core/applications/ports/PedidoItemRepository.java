package br.com.fiap.fastfood.core.applications.ports;

import br.com.fiap.fastfood.core.domain.PedidoItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoItemRepository extends JpaRepository<PedidoItem, Long> {
}
