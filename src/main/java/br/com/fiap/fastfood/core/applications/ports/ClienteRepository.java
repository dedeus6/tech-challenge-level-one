package br.com.fiap.fastfood.core.applications.ports;

import br.com.fiap.fastfood.core.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
