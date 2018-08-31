package com.joaolucas.moviegalerysas.config.interfaces;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Logger implements ILogger {

    private final org.slf4j.Logger logger;

    public Logger(){
        this.logger = LoggerFactory.getLogger(this.getClass());
    }

    @Override
    public void info(String message) {
        logger.info(message);
    }

    @Override
    public void debug(String message) {
        logger.debug(message);
    }

    @Override
    public void error(String message) {
        logger.error(message);
    }
}
