package com.trade.trading.service;

import com.razorpay.RazorpayException;
import com.trade.trading.domain.PaymentMethod;
import com.trade.trading.entity.PaymentOrder;
import com.trade.trading.entity.User;
import com.trade.trading.response.PaymentResponse;

public interface PaymentService {
PaymentOrder createOrder(User user,Long amount,PaymentMethod paymentMethod);
PaymentOrder getPaymentOrderById(Long id) throws Exception;
Boolean proccedPaymentOrder(PaymentOrder paymentOrder,String paymentId) throws RazorpayException;
PaymentResponse createRazorpayPaymentLink(User user,Long amount) throws RazorpayException;
PaymentResponse createStripePaymentLink(User user,Long amount,Long orderId);


}
