package com.elidjongrembi.transactions.api.rest;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import com.elidjongrembi.transactions.domain.ResponseJson;
import com.elidjongrembi.transactions.exception.DataFormatException;
import com.elidjongrembi.transactions.exception.ResourceNotFoundException;

/**
 * Base controller to provide common functionalities and error handling to all controllers.
 */
@ControllerAdvice
public abstract class BaseController implements ApplicationEventPublisherAware {

    protected final Logger log = LoggerFactory.getLogger(this.getClass());
    protected ApplicationEventPublisher eventPublisher;

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(DataFormatException.class)
    public
    @ResponseBody
    ResponseJson handleDataStoreException(DataFormatException ex, WebRequest request, HttpServletResponse response) {
        return new ResponseJson(ex, "There's something wrong with your request.");
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ResourceNotFoundException.class)
    public
    @ResponseBody
    ResponseJson handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request, HttpServletResponse response) {
        
        return new ResponseJson(ex, "This Entity doesn't exist!");
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.eventPublisher = applicationEventPublisher;
    }

    public static <T> T checkResourceFound(final T resource) {
        if (resource == null) {
            throw new ResourceNotFoundException("Resource not found!");
        }
        return resource;
    }

}