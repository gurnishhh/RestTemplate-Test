package com.example.demo.service;
import java.util.List;

import com.example.demo.model.BankDetails;

@org.springframework.stereotype.Service
public interface Service {
	
	BankDetails createAccount(BankDetails acc);
	
	List<BankDetails> fetchAllAccounts();
	
	BankDetails getAccountByID (int id);

	String deleteAccount (int id);
	
	BankDetails deposit(int accountNumber , double amount);
	
	BankDetails withdrawl(int id, double amount);
	
	public String Transfer(int fromAccountId, int toAccountId, double amount);
	
}
