package com.trade.trading.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class PaymentDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	
	private String accountNumber;
	
	
	private String  accountHolderName;
	
	
	private String ifsc;
	
	
	private String bankName;
	
	@OneToOne
	@JsonProperty(access = Access.WRITE_ONLY)
	private User user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public String getIfsc() {
		return ifsc;
	}

	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public PaymentDetails(String accountNumber, String accountHolderName, String ifsc, String bankName, User user) {
		super();
		this.accountNumber = accountNumber;
		this.accountHolderName = accountHolderName;
		this.ifsc = ifsc;
		this.bankName = bankName;
		this.user = user;
	}

	public PaymentDetails() {
		super();
	}
	
	
	
	
	
	
	
	
	
	
}
