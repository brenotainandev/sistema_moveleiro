package br.edu.ifba.sistema_moveleiro.config;

import br.edu.ifba.sistema_moveleiro.decorator.LoggingProdutoServiceDecorator;
import br.edu.ifba.sistema_moveleiro.observer.EventManager;
import br.edu.ifba.sistema_moveleiro.repositorio.EstoqueRepository;
import br.edu.ifba.sistema_moveleiro.repositorio.ProdutoRepository;
import br.edu.ifba.sistema_moveleiro.servico.EstoqueService;
import br.edu.ifba.sistema_moveleiro.servico.ProdutoService;
import br.edu.ifba.sistema_moveleiro.servico.impl.EstoqueServiceImpl;
import br.edu.ifba.sistema_moveleiro.servico.impl.ProdutoServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {
    @Bean
    public ProdutoService produtoService(ProdutoRepository repository, EventManager eventManager) {
        ProdutoService base = new ProdutoServiceImpl(repository, eventManager);
        return new LoggingProdutoServiceDecorator(base);
    }

    @Bean
    public EstoqueService estoqueService(EstoqueRepository repository) {
        return new EstoqueServiceImpl(repository);
    }
}
