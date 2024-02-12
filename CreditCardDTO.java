package com.example.creditcardvalidate1.DTO;


public class CreditCardDTO {
	private String cardNumber;
	private String cardHolderName;

	public CreditCardDTO() {
	}

	public CreditCardDTO(String cardNumber, String cardHolderName) {
		this.cardNumber = cardNumber;
		this.cardHolderName = cardHolderName;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardHolderName() {
		return cardHolderName;
	}

	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}

}
