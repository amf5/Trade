package com.trade.trading.service;

import com.trade.trading.entity.PaymentDetails;
import com.trade.trading.entity.User;

public interface PaymentDetailsService {

	
	public PaymentDetails addPaymentDetails(String accountNumber,String accountHolderName,String ifsc,String bankName,User user);
	
	public PaymentDetails getUsersPaymentDetails(User user);
	
	
	
}
