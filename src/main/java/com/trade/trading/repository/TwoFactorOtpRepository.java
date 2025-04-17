package com.trade.trading.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trade.trading.entity.TwoFactorOtp;

@Repository
public interface TwoFactorOtpRepository  extends JpaRepository<TwoFactorOtp, String>{
	TwoFactorOtp findByUserId(Long userId);
	

}
