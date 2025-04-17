package com.trade.trading.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trade.trading.domain.OrderType;
import com.trade.trading.entity.Coin;
import com.trade.trading.entity.Order;
import com.trade.trading.entity.User;
import com.trade.trading.request.CreatedOrderRequest;
import com.trade.trading.service.CoinService;
import com.trade.trading.service.OrderService;
import com.trade.trading.service.UserService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
@Autowired
private OrderService orderService;
@Autowired
private UserService userService;
@Autowired
private CoinService coinService;
//@Autowired 
//private WalletTransactionService walletTransactionService;



@PostMapping("/pay")
public ResponseEntity<Order> payOrderPayment(
		@RequestHeader("Authorization") String jwt,
		@RequestBody CreatedOrderRequest req
		)throws Exception{
	
	User user=userService.findUserProfileByJwt(jwt);
	Coin coin=coinService.findById(req.getCoinId());
	
	
	Order order=orderService.processOrder(coin,req.getQuantity(), req.getOrderType(), user);
	
	return ResponseEntity.ok(order);
	
}



@GetMapping("/{orderId}")
public ResponseEntity<Order>getOrderById(@RequestHeader("Authorization") String token,
		@PathVariable Long orderId)throws Exception{
	
	
	User user=userService.findUserProfileByJwt(token);
	Order order=orderService.getOrderById(orderId);
	if(order.getUser().getId().equals(user.getId())) {
		
		return ResponseEntity.ok(order);
	}else {
		throw new Exception("you don't have access");
		
		//return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
	}
	
}
	@GetMapping()
	public ResponseEntity<List<Order>> getAllOrdersForUser(@RequestHeader("Authorization")String jwt,
			@RequestParam(required = false)OrderType orderType,
			@RequestParam(required = false)String assetSymbol)throws Exception{
		
		Long userId=userService.findUserProfileByJwt(jwt).getId();
		List<Order> userOrders=orderService.getAllOrdersOfUser(userId, orderType, assetSymbol);
		return ResponseEntity.ok(userOrders);
	}
	
	
}
