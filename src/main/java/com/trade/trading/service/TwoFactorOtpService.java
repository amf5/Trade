package com.trade.trading.service;



import com.trade.trading.entity.TwoFactorOtp;
import com.trade.trading.entity.User;


public interface TwoFactorOtpService {

	
	
	TwoFactorOtp createTwoFactorOtp(User user,String otp,String jwt) ;
	TwoFactorOtp findByUser(Long userId);
	TwoFactorOtp findById(String id);
	boolean verifyTwoFactorOtp(TwoFactorOtp twoFactorOtp,String otp);
	void deleteTwoFactorOtp(TwoFactorOtp twoFactorOtp );
}
