package com.inventory.orderservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.orderservice.dao.IOrderDAO;
import com.inventory.orderservice.dto.OrderS;



@Service
public class OrderServiceImpl implements IOrderService{
	
	@Autowired
	private IOrderDAO daoRef;

	@Override
	public void placeOrder(OrderS orders) {
		daoRef.save(orders);
		
	}

	@Override
	public List<OrderS> getAll() {
		return daoRef.findAll();
		
	}
	
	

}
