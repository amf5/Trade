package com.trade.trading.entity;

import com.trade.trading.domain.VerificationType;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;

@Embeddable
public class TwoFactorAuth {
private boolean isEnabled=false;
private VerificationType sendTo;
public boolean isEnabled() {
	return isEnabled;
}
public void setEnabled(boolean isEnabled) {
	this.isEnabled = isEnabled;
}
public VerificationType getSendTo() {
	return sendTo;
}
public void setSendTo(VerificationType sendTo) {
	this.sendTo = sendTo;
}

}

