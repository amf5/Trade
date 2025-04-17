package com.trade.trading.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trade.trading.entity.Withdrawal;
@Repository
public interface WithdrawalRepository extends JpaRepository<Withdrawal, Long> {
 List<Withdrawal> findByUserId(Long userId);
 
}
