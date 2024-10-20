package br.com.fiap.fastfood.core.applications.ports;

import br.com.fiap.fastfood.core.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
