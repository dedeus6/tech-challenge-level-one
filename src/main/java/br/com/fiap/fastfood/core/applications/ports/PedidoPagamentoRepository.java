package br.com.fiap.fastfood.core.applications.ports;

import br.com.fiap.fastfood.core.domain.PedidoPagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoPagamentoRepository extends JpaRepository<PedidoPagamento, Long> {
}
