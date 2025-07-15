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

    @PostMapping
    public Estoque create(@RequestBody Estoque estoque) {
        return service.save(estoque);
    }

    @GetMapping
    public List<Estoque> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Estoque getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public Estoque update(@PathVariable Long id, @RequestBody Estoque estoque) {
        return service.update(id, estoque);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }
}