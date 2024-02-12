package com.example.creditcardvalidate1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.creditcardvalidate1.entity.CreditCard;
import com.example.creditcardvalidate1.service.CreditCardService;

@RestController
@RequestMapping("/creditcard")
public class CreditCardcontroller {

	@Autowired
	private CreditCardService creditCardService;

	@PostMapping("/validate")
	public String validateCreditCard(@ModelAttribute("cardNumber") String cardNumber) {
		return creditCardService.validateCreditCard(cardNumber);
	}

	@PostMapping("/save")
	public String saveCreditCard(@ModelAttribute CreditCard creditCard) {
		creditCardService.saveCreditCard(creditCard);
		return "Data saved Successfully....";
	}
}