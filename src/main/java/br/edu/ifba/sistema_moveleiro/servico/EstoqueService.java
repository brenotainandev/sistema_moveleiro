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

    public List<Estoque> findAll() {
        return repository.findAll();
    }

    public Estoque save(Estoque estoque) {
        return repository.save(estoque);
    }
}
