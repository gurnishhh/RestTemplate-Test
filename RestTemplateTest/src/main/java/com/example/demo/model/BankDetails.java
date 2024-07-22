package com.example.demo.model;


import java.util.Random;

import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.stereotype.Component;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Component


@Entity
@Table(name ="HDFC")
public class BankDetails {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "account_number")
	private Long accountNumber;
	
	private String name;
	private String email;
	 private Double balance;
	 
	 @NotNull
	 @Column(unique = true)
	 private String identificationID;
	 
	 @NotNull
	    @Column(unique = true, length = 15)
	    private String customerID;
		

	
	
	public BankDetails(Long accountNumber, String name, String email, Double balance, String identificationID,
			String customerID) {
		super();
		this.accountNumber = accountNumber;
		this.name = name;
		this.email = email;
		this.balance = balance;
		this.identificationID = identificationID;
		this.customerID = customerID;
	}

	@PrePersist
	private void onCreate() {
		this.customerID = genrateCustomerID();
	}
	
	private String genrateCustomerID(){
		
		Random random = new Random();
		 StringBuilder sb = new StringBuilder(8);
		 
		 for(int i=0; i<8; i++)
		 {
			 sb.append(random.nextInt(10));
		 }
		
		return sb.toString();
	}

	public BankDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double totalBalance) {
		this.balance = totalBalance;
	}
	
	

	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}
	
	



	public String getIdentificationID() {
		return identificationID;
	}



	public void setIdentificationID(String identificationID) {
		this.identificationID = identificationID;
	}



	public String getCustomerID() {
		return customerID;
	}



	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}



	@Override
	public String toString() {
		return "BankDetails [accountNumber=" + accountNumber + ", name=" + name + ", email=" + email + ", balance="
				+ balance + ", identificationID=" + identificationID + ", customerID=" + customerID + "]";
	}



	
	 
	
	 
	 
	
	
	
	
	
	
	

}
