package com.elidjongrembi.transactions.api.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.elidjongrembi.transactions.exception.ServiceException;
import com.elidjongrembi.transactions.service.TransactionService;

@RestController
@RequestMapping(value = "/types")
public class TypeController extends BaseController{
	
	@Autowired
	private TransactionService transactionService;
	
	@RequestMapping(value = "",
            		method = RequestMethod.GET,
            		produces = ("application/json"))
    @ResponseStatus(HttpStatus.OK)
	public @ResponseBody List<String> getTypes() throws ServiceException{
		
		List<String> types = transactionService.getTypes();
		
		return types;
	}

}
