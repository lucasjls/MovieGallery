package com.joaolucas.moviegalerysas.config.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class LoggerImpl {

    private final Logger logger;

    public LoggerImpl(){
        this.logger = (Logger) LoggerFactory.getLogger(this.getClass());
    }

    public void info(String message) {
        logger.info(message);
    }

    public void debug(String message) {
        logger.debug(message);
    }

    public void error(String message) {
        logger.error(message);
    }
}
