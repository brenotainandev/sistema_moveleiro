package br.edu.ifba.sistema_moveleiro.infrastructure.repository;

import br.edu.ifba.sistema_moveleiro.domain.model.produto.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}