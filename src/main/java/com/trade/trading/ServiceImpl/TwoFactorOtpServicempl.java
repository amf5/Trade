package com.trade.trading.ServiceImpl;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trade.trading.entity.TwoFactorOtp;
import com.trade.trading.entity.User;
import com.trade.trading.repository.TwoFactorOtpRepository;
import com.trade.trading.service.TwoFactorOtpService;

@Service
public class TwoFactorOtpServicempl implements TwoFactorOtpService {
@Autowired
private TwoFactorOtpRepository twoFactorOtpRepository;
	@Override
	public TwoFactorOtp createTwoFactorOtp(User user, String otp, String jwt) {
		UUID uuid=UUID.randomUUID();
		String id=uuid.toString();
		TwoFactorOtp twoFactorOtp=new TwoFactorOtp();
		twoFactorOtp.setOtp(otp);
		twoFactorOtp.setJwt(jwt);
		twoFactorOtp.setId(id);
		twoFactorOtp.setUser(user);
		return twoFactorOtpRepository.save(twoFactorOtp);
	}

	@Override
	public TwoFactorOtp findByUser(Long userId) {
		
		return twoFactorOtpRepository.findByUserId(userId);
	}

	@Override
	public TwoFactorOtp findById(String id) {
		Optional<TwoFactorOtp>otp=twoFactorOtpRepository.findById(id);
		
		return otp.orElse(null);
	}

	@Override
	public boolean verifyTwoFactorOtp(TwoFactorOtp twoFactorOtp, String otp) {
		
		return twoFactorOtp.getOtp().equals(otp);
	}

	@Override
	public void deleteTwoFactorOtp(TwoFactorOtp twoFactorOtp) {
		twoFactorOtpRepository.delete(twoFactorOtp);
		
	}

}
