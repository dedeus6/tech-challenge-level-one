package br.com.fiap.fastfood.adapter.out.persistence.repository;

import br.com.fiap.fastfood.adapter.out.persistence.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
