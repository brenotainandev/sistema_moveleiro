package br.edu.ifba.sistema_moveleiro.servico;

import br.edu.ifba.sistema_moveleiro.entidade.Produto;
import br.edu.ifba.sistema_moveleiro.repositorio.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {
    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public List<Produto> findAll() {
        return repository.findAll();
    }

    public Produto save(Produto produto) {
        return repository.save(produto);
    }
}