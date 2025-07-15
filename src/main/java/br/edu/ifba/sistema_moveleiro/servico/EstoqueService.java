package br.edu.ifba.sistema_moveleiro.servico;

import br.edu.ifba.sistema_moveleiro.entidade.Estoque;
import br.edu.ifba.sistema_moveleiro.repositorio.EstoqueRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstoqueService {
    private final EstoqueRepository repository;

    public EstoqueService(EstoqueRepository repository) {
        this.repository = repository;
    }

    public Estoque save(Estoque estoque) {
        return repository.save(estoque);
    }

    public List<Estoque> findAll() {
        return repository.findAll();
    }

    public Estoque findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estoque não encontrado com ID: " + id));
    }

    public Estoque update(Long id, Estoque estoque) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Estoque não encontrado com ID: " + id);
        }
        estoque.setId(id);
        return repository.save(estoque);
    }

    public void deleteById(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Estoque não encontrado com ID: " + id);
        }
        repository.deleteById(id);
    }
}