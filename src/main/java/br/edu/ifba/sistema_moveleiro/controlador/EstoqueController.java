package br.edu.ifba.sistema_moveleiro.controlador;

import br.edu.ifba.sistema_moveleiro.entidade.Estoque;
import br.edu.ifba.sistema_moveleiro.servico.EstoqueService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estoques")
public class EstoqueController {
    private final EstoqueService service;

    public EstoqueController(EstoqueService service) {
        this.service = service;
    }

    @GetMapping
    public List<Estoque> getAll() {
        return service.findAll();
    }

    @PostMapping
    public Estoque create(@RequestBody Estoque estoque) {
        return service.save(estoque);
    }
}
