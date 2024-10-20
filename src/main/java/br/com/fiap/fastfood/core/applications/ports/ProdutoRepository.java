package br.com.fiap.fastfood.core.applications.ports;

import br.com.fiap.fastfood.core.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
