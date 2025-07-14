package br.edu.ifba.sistema_moveleiro.repositorio;

import br.edu.ifba.sistema_moveleiro.entidade.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}