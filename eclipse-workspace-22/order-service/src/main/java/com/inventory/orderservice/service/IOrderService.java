package com.inventory.orderservice.service;

import java.util.List;

import com.inventory.orderservice.dto.OrderS;

public interface IOrderService {
	
	public void placeOrder(OrderS order);
	public List<OrderS> getAll();

}
