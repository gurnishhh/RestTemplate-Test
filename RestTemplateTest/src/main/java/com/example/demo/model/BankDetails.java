package com.example.demo.model;


import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.stereotype.Component;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Component


@Entity
@Table(name ="HDFC")
public class BankDetails {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String email;
	 private Double balance;
		

	public BankDetails(Long id, String name, String email, Double balance) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.balance = balance;
	}



	public BankDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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



	@Override
	public String toString() {
		return "BankDetails [id=" + id + ", name=" + name + ", email=" + email + ", balance=" + balance + "]";
	}



	
	 
	
	 
	 
	
	
	
	
	
	
	

}
