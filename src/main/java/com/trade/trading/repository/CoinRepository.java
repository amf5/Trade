package com.trade.trading.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trade.trading.entity.Coin;
@Repository
public interface CoinRepository extends JpaRepository<Coin, String> {

}
