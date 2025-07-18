package br.edu.ifba.sistema_moveleiro.application.service;

import br.edu.ifba.sistema_moveleiro.domain.model.produto.builder.ProdutoBuilder;
import br.edu.ifba.sistema_moveleiro.domain.model.produto.Produto;
import br.edu.ifba.sistema_moveleiro.infrastructure.repository.ProdutoRepository;
import br.edu.ifba.sistema_moveleiro.domain.service.CalculadoraDePreco;
import br.edu.ifba.sistema_moveleiro.domain.strategy.DescontoBlackFriday;
import br.edu.ifba.sistema_moveleiro.domain.strategy.DescontoStrategy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {
    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public Produto save(Produto produto) {
        DescontoStrategy descontoStrategy = new DescontoBlackFriday();
        CalculadoraDePreco calculadora = new CalculadoraDePreco();
        double precoComDesconto = calculadora.aplicarDesconto(produto.getProductPrice(), descontoStrategy);
        Produto novoProduto = new ProdutoBuilder()
                .comCodigo(produto.getProductCode())
                .comNome(produto.getProductName())
                .comDescricao(produto.getProductDescription())
                .comCor(produto.getProductColor())
                .comPreco(precoComDesconto)
                .build();

        return repository.save(novoProduto);
    }

    public List<Produto> findAll() {
        return repository.findAll();
    }

    public Produto findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado com ID: " + id));
    }

    public Produto update(Long id, Produto produto) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Produto não encontrado com ID: " + id);
        }
        produto.setId(id);
        return repository.save(produto);
    }

    public void deleteById(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Produto não encontrado com ID: " + id);
        }
        repository.deleteById(id);
    }
}