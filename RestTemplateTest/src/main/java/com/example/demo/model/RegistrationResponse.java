package com.example.demo.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class RegistrationResponse {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long customerID;
	

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long accountNumber;

}
