package br.edu.ifba.sistema_moveleiro.builder;

import br.edu.ifba.sistema_moveleiro.entidade.Estoque;
import br.edu.ifba.sistema_moveleiro.entidade.Produto;

import java.time.LocalDateTime;

public class EstoqueBuilder {
    private final Estoque estoque;

    public EstoqueBuilder() {
        this.estoque = new Estoque();
        this.estoque.setCreatedAt(LocalDateTime.now());
        this.estoque.setUpdatedAt(LocalDateTime.now());
    }

    public EstoqueBuilder comProduto(Produto produto) {
        estoque.setProduto(produto);
        return this;
    }

    public EstoqueBuilder comQuantidade(Integer quantidade) {
        estoque.setProductQuantity(quantidade);
        return this;
    }

    public Estoque build() {
        return estoque;
    }
}
