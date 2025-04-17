package com.trade.trading.entity;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Wallet {
   @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
	private Long id;
	@OneToOne
   private User user;
	
	private BigDecimal belance;

	public Wallet() {
		super();
	}

	public Wallet(User user, BigDecimal belance) {
		super();
		this.user = user;
		this.belance = belance;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public BigDecimal getBelance() {
		return belance;
	}

	public void setBelance(BigDecimal belance) {
		this.belance = belance;
	}
	
}
