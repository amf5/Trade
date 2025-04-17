package com.trade.trading.request;

import com.trade.trading.domain.OrderType;

public class CreatedOrderRequest {
private String coinId;
private double quantity;
private OrderType orderType;
public String getCoinId() {
	return coinId;
}
public void setCoinId(String coinId) {
	this.coinId = coinId;
}
public double getQuantity() {
	return quantity;
}
public void setQuantity(double quantity) {
	this.quantity = quantity;
}
public OrderType getOrderType() {
	return orderType;
}
public void setOrderType(OrderType orderType) {
	this.orderType = orderType;
}
public CreatedOrderRequest() {
	super();
}
public CreatedOrderRequest(String coinId, double quantity, OrderType orderType) {
	super();
	this.coinId = coinId;
	this.quantity = quantity;
	this.orderType = orderType;
}

}
