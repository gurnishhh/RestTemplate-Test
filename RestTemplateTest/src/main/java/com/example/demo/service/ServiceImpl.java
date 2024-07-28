package com.example.demo.service;

import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import com.example.demo.bankrepository.Repository;
import com.example.demo.model.BankDetails;
import com.example.demo.model.EmailRequest;


@org.springframework.stereotype.Service
public class ServiceImpl implements Service {

	@Autowired
	private Repository repo;
	
	@Autowired 
	  RestTemplate restTemplate;
	
	@Override
	public BankDetails createAccount(BankDetails acc) {
		
		repo.save(acc);
		
		return null;
	}
	
	@Override
	public List<BankDetails> fetchAllAccounts() {
		
		List<BankDetails> bank = (List<BankDetails>) repo.findAll();
		return bank;
	}

	@Override
	public BankDetails getAccountByID(int id) {
		
		Optional<BankDetails> bank =  repo.findById(id);
		if(bank.isPresent() )
		{
			return bank.get();
		}
		return null;
		
		
	}

	@Override
	public String deleteAccount(int id) {
		
		if(repo.findById(id).isPresent())
		{
			repo.deleteById(id);
			return "Successfully deleted " ;
		}
		
		else
			return "No such Account in the database";
		
		
	}

	@Override
	public BankDetails deposit(int accountNumber, double amount) {
		
		
		BankDetails account = fetchBankDetailsById(accountNumber);
		
		 if (account == null) {
	            throw new IllegalArgumentException("Account not found");
	        }
		
			account.setBalance( account.getBalance() + amount );
			saveBankDetails(account);
			
			String useremail = account.getEmail();
			
			EmailRequest emailRequest = new EmailRequest(useremail, " Deposit Confirmation", "Your deposit of " + amount + "Rs was successful.");
			HttpEntity<EmailRequest> request = new HttpEntity<>(emailRequest);
			
			restTemplate.postForObject("http://localhost:8081/sendMail",request, String.class);
			
			return account;
			
		
	}

	@Override
	public BankDetails withdrawl(int id, double amount) {
		
		Optional<BankDetails> bank =	repo.findById(id);
		
		if(bank.isEmpty())
		{
			throw new RuntimeException("Account with this ID is not present.");
		}
			BankDetails bankPresent = bank.get();
			
		double newBalance = bankPresent.getBalance() - amount ;
		
		if(newBalance < 0)
		{
		  throw new RuntimeException("Not enough balance"); 
			
		}
		else {
		bankPresent.setBalance(newBalance);
		
		String useremail = bankPresent.getEmail();
		
		EmailRequest emailRequest = new EmailRequest(useremail, " Withdrawl Confirmation", "Your withdrawl of " + amount + "rs was successful.");
		HttpEntity<EmailRequest> request = new HttpEntity<>(emailRequest);
		
		restTemplate.postForObject("http://localhost:8081/sendMail",request, String.class);
		
		repo.save(bankPresent);
		}
		
		
		return bankPresent;
	}

	@Override
	public String Transfer(int fromAccountId, int toAccountId, double amount) {
		
		BankDetails fromAccount = fetchBankDetailsById(fromAccountId);
		BankDetails toAccount = fetchBankDetailsById(toAccountId);
		
		if(fromAccount.getBalance() < amount) {
			return "insufficient balance";
		}
		
		fromAccount.setBalance( fromAccount.getBalance() - amount );
		toAccount.setBalance( toAccount.getBalance() + amount );
		
		
		saveBankDetails(fromAccount);
		saveBankDetails(toAccount);
		
		
		return "Transfer Successful";
	}
	
	private BankDetails fetchBankDetailsById(int accountNumber) {
		return repo.findById(accountNumber).orElseThrow(()-> new RuntimeException("Account not found"));
	}

	private void saveBankDetails(BankDetails account) {
        repo.save(account);
    }
	
	
}
