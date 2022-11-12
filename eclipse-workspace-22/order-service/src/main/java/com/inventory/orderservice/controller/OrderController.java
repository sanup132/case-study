package com.inventory.orderservice.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

//import org.springframework.context.annotation.Bean;

import com.inventory.orderservice.dto.OrderS;
import com.inventory.orderservice.dto.AccountS;
import com.inventory.orderservice.service.IOrderService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class OrderController {
	
	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
	
	@Autowired
	private RestTemplate restTamplate;
	
	@Autowired
	IOrderService orderServiceRef;
	
	
	private String BASE_URI="http://locahost:9095/account-service";
	
	@RequestMapping("/welcome")
	public String welcomeEmployee()
	{
		return "Hello Employee";
	}
	
	
	// POST http://localhost:9094/orders content-type application/json
	@RequestMapping(method=RequestMethod.POST, value="/orders")
    public String placeOrder(OrderS orders)
    {
		logger.info("::Before place order::");
		String accountNumber = orders.getCustAccountNo();
		double  amount = orders.getAmount();
		String uri= BASE_URI +"/account/"+accountNumber+"/"+amount;
		AccountS account = (AccountS)restTamplate.getForObject(uri,AccountS.class);
		logger.info("::After place order::");
		String status="success";
		return status;		
    }
	
	
	// GET http://localhost:9094/orders
	@RequestMapping("/orders")
    public List<OrderS> getAll()
    {
		return orderServiceRef.getAll();
    }
	
	/*
	 * @Bean public RestTemplate restTemplate() { return new RestTemplate(); }
	 */
}
