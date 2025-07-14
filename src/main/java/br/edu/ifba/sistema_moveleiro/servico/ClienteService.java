package br.edu.ifba.sistema_moveleiro.servico;

import br.edu.ifba.sistema_moveleiro.entidade.Cliente;
import br.edu.ifba.sistema_moveleiro.repositorio.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    public List<Cliente> findAll() {
        return repository.findAll();
    }

    public Cliente save(Cliente cliente) {
        return repository.save(cliente);
    }
}