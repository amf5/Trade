package com.trade.trading.ServiceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trade.trading.domain.VerificationType;
import com.trade.trading.entity.User;
import com.trade.trading.entity.VerificationCode;
import com.trade.trading.repository.VerificationCodeRepository;
import com.trade.trading.service.VerificationCodeService;
import com.trade.trading.utils.OtpUtils;
@Service
public class VerificationCodeServiceImpl implements VerificationCodeService {
@Autowired
private VerificationCodeRepository verificationCodeRepository;
	

	@Override
	public VerificationCode getVerificationCodeById(Long id) throws Exception {
		Optional<VerificationCode> verificationCode=verificationCodeRepository.findById(id);
		if(verificationCode.isPresent()) {
			
			return verificationCode.get();
		}
		throw new Exception("verification code not found");
	}

	@Override
	public VerificationCode getVerificationCodeByUser(Long userId) {
		
		return verificationCodeRepository.findByUserId(userId);
	}

	@Override
	public void deleteVerificationById(VerificationCode verificationCode) {
	verificationCodeRepository.delete(verificationCode);
		
	}

	@Override
	public VerificationCode sendVerificationCode(User user, VerificationType verificationType) {
		VerificationCode verificationCode1=new VerificationCode();
		verificationCode1.setOtp(OtpUtils.generateOtp());
		verificationCode1.setVerificationType(verificationType);
		verificationCode1.setUser(user);
		
		return verificationCodeRepository.save(verificationCode1);
	}

}
