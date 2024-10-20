package br.com.fiap.fastfood.core.applications.ports;

import br.com.fiap.fastfood.core.domain.FormaPagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormaPagamentoRepository extends JpaRepository<FormaPagamento, Long> {
}
