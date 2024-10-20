package br.com.fiap.fastfood.adapter.out.persistence.repository;

import br.com.fiap.fastfood.adapter.out.persistence.entity.FormaPagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormaPagamentoRepository extends JpaRepository<FormaPagamento, Long> {
}
