package br.edu.ifba.sistema_moveleiro.repositorio;

import br.edu.ifba.sistema_moveleiro.entidade.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}