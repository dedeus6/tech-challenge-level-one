package br.com.fiap.fastfood.core.applications.ports;

import br.com.fiap.fastfood.core.domain.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
}
