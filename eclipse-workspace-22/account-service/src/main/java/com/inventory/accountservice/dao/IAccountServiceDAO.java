package com.inventory.accountservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inventory.accountservice.dto.AccountS;

@Repository
public interface IAccountServiceDAO extends JpaRepository<AccountS, Long>{
	
   AccountS findByAccountNumber(int accountNumber, double amount);
}
