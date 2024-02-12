package com.example.creditcardvalidate1.service;

import com.example.creditcardvalidate1.entity.CreditCard;

public interface CreditCardService {
	String validateCreditCard(String cardNumber);
	CreditCard saveCreditCard(CreditCard creditCard);
}
