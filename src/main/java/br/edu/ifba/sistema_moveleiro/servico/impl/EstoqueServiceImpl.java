package br.edu.ifba.sistema_moveleiro.servico.impl;

import br.edu.ifba.sistema_moveleiro.builder.EstoqueBuilder;
import br.edu.ifba.sistema_moveleiro.entidade.Estoque;
import br.edu.ifba.sistema_moveleiro.repositorio.EstoqueRepository;
import br.edu.ifba.sistema_moveleiro.servico.EstoqueService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstoqueServiceImpl implements EstoqueService {
    private final EstoqueRepository repository;

    public EstoqueServiceImpl(EstoqueRepository repository) {
        this.repository = repository;
    }

    @Override
    public Estoque save(Estoque estoque) {
        Estoque novoEstoque = new EstoqueBuilder()
                .comProduto(estoque.getProduto())
                .comQuantidade(estoque.getProductQuantity())
                .build();
        return repository.save(novoEstoque);
    }

    @Override
    public List<Estoque> findAll() {
        return repository.findAll();
    }

    @Override
    public Estoque findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estoque não encontrado com ID: " + id));
    }

    @Override
    public Estoque update(Long id, Estoque estoque) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Estoque não encontrado com ID: " + id);
        }
        estoque.setId(id);
        return repository.save(estoque);
    }

    @Override
    public void deleteById(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Estoque não encontrado com ID: " + id);
        }
        repository.deleteById(id);
    }
}
