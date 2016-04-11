package com.elidjongrembi.transactions.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Transaction")
public class Transaction {
	
	public Transaction(String type, double amount, long parentId) {
		this.type = type;
		this.amount = amount;
		this.parentId = parentId;
	}
	public Transaction(){
		
	}
	
	public long getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public long getParentId() {
		return parentId;
	}
	public void setParentId(long parentId) {
		this.parentId = parentId;
	}
	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", type=" + type + ", amount=" + amount + ", parentId="
				+ parentId + "]";
	}
	
	@Id
    @GeneratedValue()
	private long transactionId;
	
	@Column(nullable = false)
	private String type;
	
	@Column
	private double amount;
	
	@Column
	private long parentId;
}
