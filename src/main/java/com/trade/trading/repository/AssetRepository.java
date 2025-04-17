package com.trade.trading.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trade.trading.entity.Asset;

@Repository
public interface AssetRepository extends JpaRepository<Asset, Long> {
	List<Asset>findByUserId(Long userId);
	Asset findByUserIdAndCoinId(Long userId,String coinId );

}
