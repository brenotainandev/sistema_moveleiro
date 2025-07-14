package br.edu.ifba.sistema_moveleiro.repositorio;

import br.edu.ifba.sistema_moveleiro.entidade.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstoqueRepository extends JpaRepository<Estoque, Long> {}
