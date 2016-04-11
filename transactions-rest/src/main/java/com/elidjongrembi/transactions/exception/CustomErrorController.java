package com.elidjongrembi.transactions.exception;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.elidjongrembi.transactions.domain.ErrorJson;

@RestController
public class CustomErrorController implements ErrorController {

    private static final String PATH = "/error";
    private static final Logger log = LoggerFactory.getLogger(CustomErrorController.class);

    @Autowired
    private ErrorAttributes errorAttributes;

    @RequestMapping(value = PATH)
    ErrorJson error(HttpServletRequest request, HttpServletResponse response) {
        
    	log.info("An error is occuring...");
        return new ErrorJson(response.getStatus(), getErrorAttributes(request, false));
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }

    private Map<String, Object> getErrorAttributes(HttpServletRequest request, boolean includeStackTrace) {
        RequestAttributes requestAttributes = new ServletRequestAttributes(request);
        return errorAttributes.getErrorAttributes(requestAttributes, includeStackTrace);
    }

}