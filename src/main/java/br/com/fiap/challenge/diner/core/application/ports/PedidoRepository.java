package br.com.fiap.challenge.diner.core.application.ports;

import br.com.fiap.challenge.diner.core.domain.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
