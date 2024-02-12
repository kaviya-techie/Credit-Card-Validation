package com.example.creditcardvalidate1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.creditcardvalidate1.entity.CreditCard;
import com.example.creditcardvalidate1.repository.CreditCardRepo;

@Service
public class CreditCardServiceImpl implements CreditCardService {

	@Autowired
	private  CreditCardRepo creditcardrepo;

	@Override
	public String validateCreditCard(String cardNumber) {
		String cardType = getCardType(cardNumber);
		if (cardType != null) {
			boolean Valid = creditCardvalid(cardNumber);
			if (Valid) {
				return "Card Type: " + cardType + " - Valid credit card number";
			} else {
				return "Card Type: " + cardType + " - Invalid credit card number";
			}
		} else {
			return "Unknown card type or Invalid credit card number";
		}
	}

	private String getCardType(String cardNumber) {
		int length = cardNumber.length();
		if (length == 15) {
			if ((cardNumber.startsWith("37")) || (cardNumber.startsWith("34"))) {
				return "American Express";
			} else if ((cardNumber.startsWith("2123")) || (cardNumber.startsWith("1800"))) {
				return "JCB";
			}
		} else if ((length == 16) || (length == 13)) {
			if ((cardNumber.startsWith("51")) || (cardNumber.startsWith("52")) || (cardNumber.startsWith("53"))
					|| (cardNumber.startsWith("54")) || (cardNumber.startsWith("55"))) {
				return "Master Card";
			} else if (cardNumber.startsWith("3")) {
				return "JCB";
			} else if (cardNumber.startsWith("4")) {
				return "Visa";
			} else if (cardNumber.startsWith("6011")) {
				return "Discover";
			} else if ((cardNumber.startsWith("60")) || (cardNumber.startsWith("6521"))
					|| (cardNumber.startsWith("6522"))) {
				return "Rupay Card";
			}
		} else if (length == 14) {
			if ((cardNumber.startsWith("36")) || (cardNumber.startsWith("38")) || (cardNumber.startsWith("300"))
					|| (cardNumber.startsWith("301")) || (cardNumber.startsWith("302"))
					|| (cardNumber.startsWith("303")) || (cardNumber.startsWith("304"))
					|| (cardNumber.startsWith("305"))) {
				return "Diners club and Carte blanche";
			}
		}	
		return null;

	}

	private boolean creditCardvalid(String cardNumber) {
		char ch[] = cardNumber.toCharArray();
		int d[] = new int[ch.length / 2];
		int r[] = new int[d.length];

		int j = 0;
		for (int i = ch.length - 2; i >= 0; i -= 2) {
			d[j++] = (ch[i] - 48) * 2;
		}

		int k = 0;
		for (int i = 1; i <= ch.length; i += 2) {
			r[k++] = (ch[i] - 48);
		}

		int s1 = 0;
		for (int i = 0; i < d.length; i++) {
			int r1 = d[i] % 10;
			int d1 = d[i] / 10;
			s1 += d1 + r1;
		}

		int s2 = 0;
		for (int i = 0; i < r.length; i++) {
			s2 += r[i];
		}

		int sol = s1 + s2;

		return sol % 10 == 0;
	}

	@Override
	public CreditCard saveCreditCard(CreditCard creditCard) {
		return creditcardrepo.save(creditCard);
	}
}
