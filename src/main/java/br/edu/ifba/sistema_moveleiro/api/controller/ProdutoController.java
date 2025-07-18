package br.edu.ifba.sistema_moveleiro.api.controller;

import br.edu.ifba.sistema_moveleiro.domain.model.produto.Produto;
import br.edu.ifba.sistema_moveleiro.application.service.ProdutoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    private final ProdutoService service;

    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    @PostMapping
    public Produto create(@RequestBody Produto produto) {
        return service.save(produto);
    }

    @GetMapping
    public List<Produto> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Produto getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public Produto update(@PathVariable Long id, @RequestBody Produto produto) {
        return service.update(id, produto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }

}