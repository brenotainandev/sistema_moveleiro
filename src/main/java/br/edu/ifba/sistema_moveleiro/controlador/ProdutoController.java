package br.edu.ifba.sistema_moveleiro.controlador;

import br.edu.ifba.sistema_moveleiro.entidade.Produto;
import br.edu.ifba.sistema_moveleiro.servico.ProdutoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    private final ProdutoService service;

    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Produto> getAll() {
        return service.findAll();
    }

    @PostMapping
    public Produto create(@RequestBody Produto produto) {
        return service.save(produto);
    }
}