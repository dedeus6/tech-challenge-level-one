package br.com.fiap.fastfood.domain.applications.ports;

import br.com.fiap.fastfood.domain.domain.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
