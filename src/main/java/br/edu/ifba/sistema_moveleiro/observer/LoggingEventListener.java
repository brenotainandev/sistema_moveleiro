package br.edu.ifba.sistema_moveleiro.observer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class LoggingEventListener implements EventListener {
    private static final Logger logger = LoggerFactory.getLogger(LoggingEventListener.class);

    @Override
    public void update(String eventType, Object data) {
        logger.info("Event {} with data {}", eventType, data);
    }
}
