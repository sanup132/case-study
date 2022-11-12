package com.inventory.orderservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inventory.orderservice.dto.OrderS;

@Repository
public interface IOrderDAO extends JpaRepository<OrderS, Long>{
	
	
}
