package br.edu.ifba.sistema_moveleiro.servico.impl;

import br.edu.ifba.sistema_moveleiro.builder.ProdutoBuilder;
import br.edu.ifba.sistema_moveleiro.entidade.Produto;
import br.edu.ifba.sistema_moveleiro.observer.EventManager;
import br.edu.ifba.sistema_moveleiro.repositorio.ProdutoRepository;
import br.edu.ifba.sistema_moveleiro.servico.ProdutoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoServiceImpl implements ProdutoService {
    private final ProdutoRepository repository;
    private final EventManager eventManager;

    public ProdutoServiceImpl(ProdutoRepository repository, EventManager eventManager) {
        this.repository = repository;
        this.eventManager = eventManager;
    }

    @Override
    public Produto save(Produto produto) {
        Produto novoProduto = new ProdutoBuilder()
                .comCodigo(produto.getProductCode())
                .comNome(produto.getProductName())
                .comDescricao(produto.getProductDescription())
                .comCor(produto.getProductColor())
                .comPreco(produto.getProductPrice())
                .build();

        Produto saved = repository.save(novoProduto);
        eventManager.notify("produto.salvo", saved.getId());
        return saved;
    }

    @Override
    public List<Produto> findAll() {
        return repository.findAll();
    }

    @Override
    public Produto findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado com ID: " + id));
    }

    @Override
    public Produto update(Long id, Produto produto) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Produto não encontrado com ID: " + id);
        }
        produto.setId(id);
        Produto updated = repository.save(produto);
        eventManager.notify("produto.atualizado", id);
        return updated;
    }

    @Override
    public void deleteById(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Produto não encontrado com ID: " + id);
        }
        repository.deleteById(id);
        eventManager.notify("produto.excluido", id);
    }
}
