package br.com.fiap.fastfood.domain.applications.ports;

import br.com.fiap.fastfood.domain.domain.model.PedidoPagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoPagamentoRepository extends JpaRepository<PedidoPagamento, Long> {
}
