package com.example.creditcardvalidate1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.creditcardvalidate1.entity.CreditCard;

public interface CreditCardRepo extends JpaRepository<CreditCard,Integer> {

}
