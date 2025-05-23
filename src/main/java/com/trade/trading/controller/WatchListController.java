package com.trade.trading.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trade.trading.entity.Coin;
import com.trade.trading.entity.User;
import com.trade.trading.entity.WatchList;
import com.trade.trading.service.CoinService;
import com.trade.trading.service.UserService;
import com.trade.trading.service.WatchListService;

@RestController
@RequestMapping("/api/watchList")
public class WatchListController {
@Autowired
private WatchListService watchListService;
@Autowired
private UserService userService;
@Autowired
private CoinService coinService;

@GetMapping("/user")
public ResponseEntity<WatchList> getUserWatchList(@RequestHeader("Authorization")String jwt)throws Exception{
	User user=userService.findUserProfileByJwt(jwt);
	WatchList watchList=watchListService.findUserWatchList(user.getId());
	return ResponseEntity.ok(watchList);
	
	
}
@PostMapping("/create")
public ResponseEntity<WatchList>createWatchList(@RequestHeader("authorization")String jwt)throws Exception{
	
	User user=userService.findUserProfileByJwt(jwt);
	WatchList createdWatchList=watchListService.createWatchList(user);
	return  ResponseEntity.status(HttpStatus.CREATED).body(createdWatchList);
}

@GetMapping("/{watchlistId}")
public ResponseEntity<WatchList> getWatchListById(@PathVariable Long watchListId)throws Exception{
	WatchList watchList=watchListService.findById(watchListId);
	return ResponseEntity.ok(watchList);
}
@GetMapping("/add/coin/{coinId}")
public ResponseEntity<Coin> addItemToWatchList(@RequestHeader("Authorization")String jwt
		,@PathVariable String CoinId)throws Exception{
	
	User user=userService.findUserProfileByJwt(jwt);
	Coin coin=coinService.findById(CoinId);
	Coin addedCoin=watchListService.addItemToWatchList(coin, user);
	return ResponseEntity.ok(addedCoin);
}
}
