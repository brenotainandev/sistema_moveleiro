package br.edu.ifba.sistema_moveleiro.decorator;

import br.edu.ifba.sistema_moveleiro.entidade.Produto;
import br.edu.ifba.sistema_moveleiro.servico.ProdutoService;

import java.util.List;

public abstract class ProdutoServiceDecorator implements ProdutoService {
    protected final ProdutoService delegate;

    protected ProdutoServiceDecorator(ProdutoService delegate) {
        this.delegate = delegate;
    }

    @Override
    public Produto save(Produto produto) {
        return delegate.save(produto);
    }

    @Override
    public List<Produto> findAll() {
        return delegate.findAll();
    }

    @Override
    public Produto findById(Long id) {
        return delegate.findById(id);
    }

    @Override
    public Produto update(Long id, Produto produto) {
        return delegate.update(id, produto);
    }

    @Override
    public void deleteById(Long id) {
        delegate.deleteById(id);
    }
}
