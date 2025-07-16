package br.edu.ifba.sistema_moveleiro.servico;

import br.edu.ifba.sistema_moveleiro.entidade.Estoque;

import java.util.List;

public interface EstoqueService {
    Estoque save(Estoque estoque);
    List<Estoque> findAll();
    Estoque findById(Long id);
    Estoque update(Long id, Estoque estoque);
    void deleteById(Long id);
}
