package br.com.fiap.fastfood.domain.applications.ports;

import br.com.fiap.fastfood.domain.domain.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

    Empresa findByCnpj(@Param("cnpj") String cnpj);
}
