package com.trade.trading.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trade.trading.entity.PaymentDetails;
import com.trade.trading.entity.User;
import com.trade.trading.repository.PaymentDetailsRepository;
import com.trade.trading.service.PaymentDetailsService;
@Service
public class PaymentDetailsServiceImpl implements PaymentDetailsService {
@Autowired
private PaymentDetailsRepository paymentDetailsRepository;
	@Override
	public PaymentDetails addPaymentDetails(String accountNumber, String accountHolderName, String ifsc,
			String bankName, User user) {
		PaymentDetails paymentDetails=new PaymentDetails();
		paymentDetails.setAccountNumber(accountNumber);
		paymentDetails.setAccountHolderName(accountHolderName);
		paymentDetails.setBankName(bankName);
		paymentDetails.setIfsc(ifsc);
		paymentDetails.setUser(user);
		return paymentDetailsRepository.save(paymentDetails);
	}

	@Override
	public PaymentDetails getUsersPaymentDetails(User user) {
		
		return paymentDetailsRepository.findByUserId(user.getId());
	}

}
