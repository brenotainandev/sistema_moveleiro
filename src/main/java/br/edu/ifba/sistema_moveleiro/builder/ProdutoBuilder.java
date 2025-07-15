package br.edu.ifba.sistema_moveleiro.builder;

import br.edu.ifba.sistema_moveleiro.entidade.Produto;

import java.time.LocalDateTime;

public class ProdutoBuilder {

    private final Produto produto;

    public ProdutoBuilder() {
        this.produto = new Produto();
        this.produto.setCreatedAt(LocalDateTime.now());
        this.produto.setUpdatedAt(LocalDateTime.now());
    }

    public ProdutoBuilder comCodigo(Integer codigo) {
        produto.setProductCode(codigo);
        return this;
    }

    public ProdutoBuilder comNome(String nome) {
        produto.setProductName(nome);
        return this;
    }

    public ProdutoBuilder comDescricao(String descricao) {
        produto.setProductDescription(descricao);
        return this;
    }

    public ProdutoBuilder comCor(String cor) {
        produto.setProductColor(cor);
        return this;
    }

    public ProdutoBuilder comPreco(Double preco) {
        produto.setProductPrice(preco);
        return this;
    }

    public Produto build() {
        return produto;
    }
}
