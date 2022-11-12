package com.inventory.accountservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.accountservice.dto.AccountS;
import com.inventory.accountservice.service.IAccountService;



@RestController
public class AccountController {
	
	IAccountService accountServiceRef;
	
	private static final Logger logger = LoggerFactory.getLogger(AccountController.class);
	
	@RequestMapping("/account/{accountNumber}/{amount}")
	public AccountS getAccountByAccountNumber(int accountNumber, double amount)
	{
		return accountServiceRef.getAccountByAccountNo(accountNumber,amount);
	}
	
	@RequestMapping("/accounts")
    public List<AccountS> getAll()
    {
		return accountServiceRef.getAll();
    }
	
	@RequestMapping(method=RequestMethod.POST, value="/accounts")
    public void placeOrder(AccountS accountS)
    {
		logger.info("::Before save account::");
		accountServiceRef.saveAccount(accountS);
		logger.info("::After save order::");
    }
	

}
