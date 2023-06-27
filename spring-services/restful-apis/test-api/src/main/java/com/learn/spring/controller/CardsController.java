package com.learn.spring.controller;

import java.util.List;

import com.learn.spring.model.Cards;
import com.learn.spring.model.Customer;
import com.learn.spring.repository.CardsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CardsController {
	
	@Autowired
	private CardsRepository cardsRepository;

	@PostMapping("/myCards")
	public List<Cards> getCardDetails(@RequestBody Customer customer) {
		List<Cards> cards = cardsRepository.findByCustomerId(customer.getId());
		if (cards != null ) {
			return cards;
		}else {
			return null;
		}
	}

}
