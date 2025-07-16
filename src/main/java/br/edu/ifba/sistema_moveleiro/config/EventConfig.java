package br.edu.ifba.sistema_moveleiro.config;

import br.edu.ifba.sistema_moveleiro.observer.EventManager;
import br.edu.ifba.sistema_moveleiro.observer.LoggingEventListener;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EventConfig {
    private final EventManager eventManager;
    private final LoggingEventListener loggingEventListener;

    public EventConfig(EventManager eventManager, LoggingEventListener loggingEventListener) {
        this.eventManager = eventManager;
        this.loggingEventListener = loggingEventListener;
    }

    @PostConstruct
    public void init() {
        eventManager.subscribe("produto.salvo", loggingEventListener);
        eventManager.subscribe("produto.atualizado", loggingEventListener);
        eventManager.subscribe("produto.excluido", loggingEventListener);
    }
}
