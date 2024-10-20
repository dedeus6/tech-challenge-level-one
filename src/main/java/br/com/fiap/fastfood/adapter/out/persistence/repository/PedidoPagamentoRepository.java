package br.com.fiap.fastfood.adapter.out.persistence.repository;

import br.com.fiap.fastfood.adapter.out.persistence.entity.PedidoPagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoPagamentoRepository extends JpaRepository<PedidoPagamento, Long> {
}
