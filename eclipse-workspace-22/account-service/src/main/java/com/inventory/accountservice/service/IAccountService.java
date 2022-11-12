package com.inventory.accountservice.service;

import java.util.List;

import com.inventory.accountservice.dto.AccountS;

public interface IAccountService {
	
	AccountS getAccountByAccountNo(int accountNo, double amount);

	List<AccountS> getAll();

	void saveAccount(AccountS accounts);
}
