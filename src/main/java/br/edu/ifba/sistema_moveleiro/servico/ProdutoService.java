package br.edu.ifba.sistema_moveleiro.servico;

import br.edu.ifba.sistema_moveleiro.entidade.Produto;

import java.util.List;

public interface ProdutoService {
    Produto save(Produto produto);
    List<Produto> findAll();
    Produto findById(Long id);
    Produto update(Long id, Produto produto);
    void deleteById(Long id);
}
