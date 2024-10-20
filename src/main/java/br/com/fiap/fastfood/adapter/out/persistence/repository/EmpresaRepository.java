package br.com.fiap.fastfood.adapter.out.persistence.repository;

import br.com.fiap.fastfood.adapter.out.persistence.entity.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

    Empresa findByCnpj(@Param("cnpj") String cnpj);
}
