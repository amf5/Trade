package com.trade.trading.service;

import com.trade.trading.domain.VerificationType;
import com.trade.trading.entity.User;
import com.trade.trading.entity.VerificationCode;

public interface VerificationCodeService {

	VerificationCode sendVerificationCode(User user,VerificationType verificationType);
	VerificationCode getVerificationCodeById(Long id) throws Exception;
	VerificationCode getVerificationCodeByUser(Long userId);
	
	void deleteVerificationById(VerificationCode verificationCode);
	
	
	
}
