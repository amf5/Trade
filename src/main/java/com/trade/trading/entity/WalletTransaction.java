package com.trade.trading.entity;

import java.time.LocalDate;

import com.trade.trading.domain.WalletTransactionType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class WalletTransaction {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
@ManyToOne
private Wallet wallet;
private WalletTransactionType type;
private LocalDate date;
private String transferId;
private String purpose;
private Long amount;
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public Wallet getWallet() {
	return wallet;
}
public void setWallet(Wallet wallet) {
	this.wallet = wallet;
}
public WalletTransactionType getType() {
	return type;
}
public void setType(WalletTransactionType type) {
	this.type = type;
}
public LocalDate getDate() {
	return date;
}
public void setDate(LocalDate date) {
	this.date = date;
}
public String getTransferId() {
	return transferId;
}
public void setTransferId(String transferId) {
	this.transferId = transferId;
}
public String getPurpose() {
	return purpose;
}
public void setPurpose(String purpose) {
	this.purpose = purpose;
}
public Long getAmount() {
	return amount;
}
public void setAmount(Long amount) {
	this.amount = amount;
}
public WalletTransaction(Wallet wallet, WalletTransactionType type, LocalDate date, String transferId, String purpose,
		Long amount) {
	super();
	this.wallet = wallet;
	this.type = type;
	this.date = date;
	this.transferId = transferId;
	this.purpose = purpose;
	this.amount = amount;
}
public WalletTransaction() {
	super();
}


}
