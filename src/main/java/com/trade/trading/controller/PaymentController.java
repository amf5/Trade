package com.trade.trading.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.razorpay.RazorpayException;
import com.stripe.exception.StripeException;
import com.trade.trading.domain.PaymentMethod;
import com.trade.trading.entity.PaymentOrder;
import com.trade.trading.entity.User;
import com.trade.trading.response.PaymentResponse;
import com.trade.trading.service.PaymentService;
import com.trade.trading.service.UserService;

@RestController
@RequestMapping("/api")
public class PaymentController {
@Autowired
private UserService userService;
@Autowired
private PaymentService paymentService;


@PostMapping("/payment/{paymentMethod}/amount/{amount}")
public ResponseEntity<PaymentResponse> paymentHamdler(@PathVariable PaymentMethod paymentMethod,
		@PathVariable Long amount,
		@RequestHeader("Authorization") String jwt)throws Exception,RazorpayException,StripeException{
	
	User user=userService.findUserProfileByJwt(jwt);
	PaymentResponse paymentResponse;
	PaymentOrder order=paymentService.createOrder(user, amount, paymentMethod);
	
	if(paymentMethod.equals(PaymentMethod.RAZORPAY)) {
		
		paymentResponse=paymentService.createRazorpayPaymentLink(user, amount);
		
	}else {
		
		paymentResponse=paymentService.createStripePaymentLink(user, amount, order.getAmount());
	}
	return new ResponseEntity<PaymentResponse>(paymentResponse,HttpStatus.ACCEPTED);
}
}
