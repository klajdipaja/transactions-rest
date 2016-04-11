package com.elidjongrembi.transactions.service;

import java.util.List;

import com.elidjongrembi.transactions.domain.Transaction;
import com.elidjongrembi.transactions.exception.ServiceException;

public interface TransactionService extends BaseService<Transaction>{

	double sum(long transactionId) throws ServiceException;
	List<String> getTypes() throws ServiceException;
}
