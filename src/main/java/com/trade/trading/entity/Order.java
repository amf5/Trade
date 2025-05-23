package com.trade.trading.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.trade.trading.domain.OrderStatus;
import com.trade.trading.domain.OrderType;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	private User user;
	
	
	@Column(nullable = false)
	private OrderType orderType;
	
	
	@Column(nullable = false)
	private BigDecimal price;
	
	private LocalDateTime timestamp=LocalDateTime.now();
	@Column(nullable =  false)
	private OrderStatus orderStatus;
	
	@OneToOne(mappedBy = "order",cascade = CascadeType.ALL)
	
	private OrderItem orderItem;
	

	public Order(User user, OrderType orderType, BigDecimal price, LocalDateTime timestamp, OrderStatus orderStatus,
			OrderItem orderItem) {
		super();
		this.user = user;
		this.orderType = orderType;
		this.price = price;
		this.timestamp = timestamp;
		this.orderStatus = orderStatus;
		this.orderItem = orderItem;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public OrderType getOrderType() {
		return orderType;
	}

	public void setOrderType(OrderType orderType) {
		this.orderType = orderType;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public OrderItem getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(OrderItem orderItem) {
		this.orderItem = orderItem;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Order() {
		super();
	}
	
	
	
}
