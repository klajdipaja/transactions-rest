package com.elidjongrembi.transactions.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * For HTTP 404 errros
 */
public class ResourceNotFoundException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException() {
        super();
        log.info("1s constructor");
    }

    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
        log.info("2nd constructor");
    }

    public ResourceNotFoundException(String message) {
        super(message);
        log.info("3rd constructor");
    }

    public ResourceNotFoundException(Throwable cause) {
        super(cause);
        log.info("4th constructor");
    }
    
    private static final Logger log = LoggerFactory.getLogger(ResourceNotFoundException.class);
}
