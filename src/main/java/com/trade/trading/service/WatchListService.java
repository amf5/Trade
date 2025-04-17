package com.trade.trading.service;

import com.trade.trading.entity.Coin;
import com.trade.trading.entity.User;
import com.trade.trading.entity.WatchList;

public interface WatchListService {

WatchList findUserWatchList(Long userId) throws Exception;
WatchList createWatchList(User user);
WatchList findById(Long id) throws Exception;
Coin addItemToWatchList(Coin coin,User user) throws Exception;

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
