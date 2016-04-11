package com.elidjongrembi.transactions.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.elidjongrembi.transactions.dao.jpa.TransactionsRepository;
import com.elidjongrembi.transactions.domain.Transaction;
import com.elidjongrembi.transactions.exception.ResourceNotFoundException;
import com.elidjongrembi.transactions.exception.ServiceException;
import com.elidjongrembi.transactions.service.TransactionService;

@Service("transactionsService")
@Transactional(value = "transactionManager", propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class TransactionServiceImpl implements TransactionService{
	
	@Autowired
	private TransactionsRepository transactionsRepository;

	@Override
	public List<Transaction> readAll() throws ServiceException {
		return (List<Transaction>) transactionsRepository.findAll();
	}

	@Override
	public List<Transaction> readAll(Integer offset, Integer limit) throws ServiceException {
		// TODO implement in future release
		return null;
	}

	@Override
	public Transaction read(long pk) throws ServiceException {
		return transactionsRepository.findOne(pk);
	}

	@Override
	public Transaction create(Transaction entity) throws ServiceException {
		return transactionsRepository.save(entity);
	}

	@Override
	public void update(Transaction entity) throws ServiceException {
		transactionsRepository.save(entity);
	}

	@Override
	public void delete(Transaction entity) throws ServiceException {
		transactionsRepository.delete(entity);
	}

	@Override
	public int count() throws ServiceException {
		return (int) transactionsRepository.count();
	}
	
	@Override
	public double sum(long transactionId) throws ServiceException {		
		Transaction t = read(transactionId);
		if(t==null) throw new ResourceNotFoundException("Resource doesn't exist!");
		double sum=0;
		boolean flag=false;
		do{
			sum+=t.getAmount();
			if(t.getParentId()!=0){
				t=read(t.getParentId());
				log.info("::::TransactionId="+t.getTransactionId()+"::::");
			}else{
				flag=true;
			}					
		}while(!flag);
		return sum;
	}
	private static final Logger log = LoggerFactory.getLogger(TransactionServiceImpl.class);

	@Override
	public List<String> getTypes() throws ServiceException {
		List<Transaction> tList=readAll();
		List<String> types=new ArrayList<String>();
		for(Transaction current: tList){
			types.add(current.getType());
		}
		return types;
	}
}
