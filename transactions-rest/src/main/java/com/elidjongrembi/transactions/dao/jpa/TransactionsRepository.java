package com.elidjongrembi.transactions.dao.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.elidjongrembi.transactions.domain.Transaction;

public interface TransactionsRepository extends PagingAndSortingRepository<Transaction, Long>{

}
