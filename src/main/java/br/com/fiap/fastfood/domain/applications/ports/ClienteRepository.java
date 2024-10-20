package br.com.fiap.fastfood.domain.applications.ports;

import br.com.fiap.fastfood.domain.domain.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
