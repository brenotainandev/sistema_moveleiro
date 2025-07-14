package br.edu.ifba.sistema_moveleiro.controlador;

import br.edu.ifba.sistema_moveleiro.entidade.Cliente;
import br.edu.ifba.sistema_moveleiro.servico.ClienteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @GetMapping
    public List<Cliente> getAll() {
        return service.findAll();
    }

    @PostMapping
    public Cliente create(@RequestBody Cliente cliente) {
        return service.save(cliente);
    }
}