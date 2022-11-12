package com.inventory.accountservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.accountservice.dao.IAccountServiceDAO;
import com.inventory.accountservice.dto.AccountS;





@Service
public class AccountServiceImpl implements IAccountService{
	
	
	@Autowired
	private IAccountServiceDAO daoRef;

	
	@Override
	public AccountS getAccountByAccountNo(int accountNo,double amount)
	{
		return daoRef.findByAccountNumber(accountNo,amount);
	}
	
	@Override
	public List<AccountS> getAll() {
		return daoRef.findAll();
		
	}
	
	@Override
	public void saveAccount(AccountS accounts) {
		daoRef.save(accounts);
		
	}

}
