package br.edu.ifba.sistema_moveleiro.decorator;

import br.edu.ifba.sistema_moveleiro.entidade.Produto;
import br.edu.ifba.sistema_moveleiro.servico.ProdutoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class LoggingProdutoServiceDecorator extends ProdutoServiceDecorator {
    private static final Logger logger = LoggerFactory.getLogger(LoggingProdutoServiceDecorator.class);

    public LoggingProdutoServiceDecorator(ProdutoService delegate) {
        super(delegate);
    }

    @Override
    public Produto save(Produto produto) {
        logger.info("Salvando produto {}", produto.getProductName());
        Produto saved = super.save(produto);
        logger.info("Produto salvo {}", saved.getId());
        return saved;
    }

    @Override
    public Produto update(Long id, Produto produto) {
        logger.info("Atualizando produto {}", id);
        Produto updated = super.update(id, produto);
        logger.info("Produto atualizado {}", updated.getId());
        return updated;
    }

    @Override
    public void deleteById(Long id) {
        logger.info("Removendo produto {}", id);
        super.deleteById(id);
        logger.info("Produto removido {}", id);
    }

    @Override
    public List<Produto> findAll() {
        logger.info("Buscando todos os produtos");
        return super.findAll();
    }

    @Override
    public Produto findById(Long id) {
        logger.info("Buscando produto {}", id);
        return super.findById(id);
    }
}
