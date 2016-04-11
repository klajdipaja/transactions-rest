package com.elidjongrembi.transactions.api.rest;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.elidjongrembi.transactions.domain.ResponseJson;
import com.elidjongrembi.transactions.domain.Transaction;
import com.elidjongrembi.transactions.exception.DataFormatException;
import com.elidjongrembi.transactions.exception.ServiceException;
import com.elidjongrembi.transactions.service.TransactionService;

@RestController
@RequestMapping(value = "/transactions")
public class TransactionsController extends BaseController{
	
	@Autowired
	private TransactionService transactionService;

	@RequestMapping(value = "",
		            method = RequestMethod.POST,
		            consumes = ("application/json"))
    @ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody ResponseJson createTransaction(@RequestBody Transaction transaction,
            HttpServletRequest request, HttpServletResponse response) throws ServiceException{
		transactionService.create(transaction);
		log.info("Entity created...");
		
		ResponseJson responseJson=new ResponseJson();
		responseJson.setMessage("Resource Created Successfully!");
		return responseJson;
	}
	
	@RequestMapping(value = "",
            		method = RequestMethod.GET,
            		produces = ("application/json"))
    @ResponseStatus(HttpStatus.OK)
	public @ResponseBody List<Transaction> readTransaction() throws ServiceException{
		
		List<Transaction> res = transactionService.readAll();
		
		log.info("Entity read...");

		return res;
	}
	
	@RequestMapping(value = "/{id}",
            		method = RequestMethod.PUT,
            		consumes = ("application/json"))
    @ResponseStatus(HttpStatus.OK)
	public @ResponseBody ResponseJson updateTransaction(@PathVariable("id") long id,@RequestBody Transaction transaction) throws ServiceException{
		checkResourceFound(transactionService.read(id));
		if(id!=transaction.getTransactionId()) throw new DataFormatException("IDs do not match!");
		transactionService.update(transaction);
		log.info("Entity updated...");
		
		ResponseJson responseJson=new ResponseJson();
		responseJson.setMessage("Resource Updated Successfully!");
		return responseJson;
	}
	
	@RequestMapping(value = "/{id}",
            		method = RequestMethod.DELETE,
            		produces = ("application/json"))
    @ResponseStatus(HttpStatus.OK)
	public @ResponseBody ResponseJson deleteTransaction(@PathVariable long id) throws ServiceException{
		Transaction t = transactionService.read(id);
		checkResourceFound(t);
		transactionService.delete(t);
		log.info("Entity deleted...");
		
		ResponseJson responseJson=new ResponseJson();
		responseJson.setMessage("Resource Deleted Successfully!");
		return responseJson;
	}
	
	@RequestMapping(value = "/{id}",
            		method = RequestMethod.GET,
            		produces = ("application/json"))
    @ResponseStatus(HttpStatus.OK)
	public double sum(@PathVariable long id) throws ServiceException{
		return transactionService.sum(id);
	}
	
	
	private static final Logger log = LoggerFactory.getLogger(TransactionsController.class);
}
