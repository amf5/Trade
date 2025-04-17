package com.trade.trading.service;

import java.util.List;

import com.trade.trading.domain.OrderType;
import com.trade.trading.entity.Coin;
import com.trade.trading.entity.Order;
import com.trade.trading.entity.OrderItem;
import com.trade.trading.entity.User;

public interface OrderService {
Order createOrder(User user,OrderItem orderItem,OrderType orderType);
Order getOrderById(Long orderId) throws Exception;
List<Order> getAllOrdersOfUser(Long userId,OrderType OrderType,String assetSymbol);
Order processOrder(Coin coin,double quantity,OrderType orderType,User  user) throws Exception;
}
