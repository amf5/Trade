package com.trade.trading.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trade.trading.entity.ForgotPasswordToken;

@Repository
public interface ForgotPasswordRepository  extends JpaRepository<ForgotPasswordToken, String>{
ForgotPasswordToken findByUserId(Long userId);
}
