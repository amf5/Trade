package com.trade.trading.ServiceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trade.trading.entity.Coin;
import com.trade.trading.entity.User;
import com.trade.trading.entity.WatchList;
import com.trade.trading.repository.WatchListRepository;
import com.trade.trading.service.WatchListService;

@Service
public class WatchListServiceImpl  implements WatchListService{
@Autowired
private WatchListRepository watchListRepository;
	@Override
	public WatchList findUserWatchList(Long userId) throws Exception {
		WatchList watchList=watchListRepository.findByUserId(userId);
		if(watchList==null) {
			throw new Exception("watch list not found");
		}
		return watchList;
	}

	@Override
	public WatchList createWatchList(User user) {
		WatchList watchList=new WatchList();
		watchList.setUser(user);
		return watchListRepository.save(watchList);
	}

	@Override
	public WatchList findById(Long id) throws Exception {
		Optional<WatchList> optionalWatchList=watchListRepository.findById(id);
		if(optionalWatchList.isEmpty()) {
			throw new Exception("watch list not found");	
			
		}
		return optionalWatchList.get();
	}

	@Override
	public Coin addItemToWatchList(Coin coin, User user) throws Exception {
		
	WatchList watchList=findUserWatchList(user.getId());
	if(watchList.getCoins().contains(coin)) {
		watchList.getCoins().remove(coin);
	}else {
		watchList.getCoins().add(coin);
	}
	
	 watchListRepository.save(watchList) ;
	 return coin;
	}
	

}
