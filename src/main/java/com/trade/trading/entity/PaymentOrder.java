package com.trade.trading.entity;

import com.trade.trading.domain.PaymentMethod;
import com.trade.trading.domain.PaymentOrderStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class PaymentOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	
	private Long amount;
	
	private PaymentOrderStatus status;
	
	private PaymentMethod paymentMethod;
	
	@ManyToOne
	private User user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public PaymentOrderStatus getStatus() {
		return status;
	}

	public void setStatus(PaymentOrderStatus status) {
		this.status = status;
	}

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public PaymentOrder(Long amount, PaymentOrderStatus status, PaymentMethod paymentMethod, User user) {
		super();
		this.amount = amount;
		this.status = status;
		this.paymentMethod = paymentMethod;
		this.user = user;
	}

	public PaymentOrder() {
		super();
	}
	
	
	
	
	
}
