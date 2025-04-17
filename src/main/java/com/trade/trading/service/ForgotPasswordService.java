package com.trade.trading.service;

import com.trade.trading.domain.VerificationType;
import com.trade.trading.entity.ForgotPasswordToken;
import com.trade.trading.entity.User;

public interface ForgotPasswordService {
	
ForgotPasswordToken createToken(User user,String id,String otp,VerificationType verificationType,String sendTo);
ForgotPasswordToken findById(String id);
ForgotPasswordToken findByUser(Long userId);
void deleteToken(ForgotPasswordToken token);
	

}
