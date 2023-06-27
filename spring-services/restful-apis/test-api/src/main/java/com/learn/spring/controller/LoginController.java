package com.learn.spring.controller;


import java.security.Principal;
import java.util.List;

import com.learn.spring.model.Customer;
import com.learn.spring.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LoginController {

	@Autowired
	private CustomerRepository customerRepository;

	@RequestMapping("/user")
	public Customer getUserDetailsAfterLogin(Principal user) {
		List<Customer> customers = customerRepository.findByEmail(user.getName());
		if (customers.size() > 0) {
			return customers.get(0);
		}else {
			return null;
		}

	}

}
