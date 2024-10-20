package br.com.fiap.fastfood.core.applications.ports;

import br.com.fiap.fastfood.core.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
