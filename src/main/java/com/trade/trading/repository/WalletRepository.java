package com.trade.trading.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trade.trading.entity.Wallet;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Long> {
Wallet findByUserId(Long userId);
}
