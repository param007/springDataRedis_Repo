package com.javasampleapproach.redis.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javasampleapproach.redis.model.Customer;
import com.javasampleapproach.redis.repo.CustomerRepository;

@RestController
public class WebController {

	@Autowired
	private CustomerRepository customerRepository;


	//http://localhost:8080/findall
	@PostMapping("/save")
	public void save(@RequestBody Customer cust )
	{
		 customerRepository.save(cust);
	}

	//http://localhost:8080/findall
	@RequestMapping("/findall")
	public String findAll() {
		String result = "";
		Map<Long, Customer> customers = customerRepository.findAll();

		for (Customer customer : customers.values()) {
			result += customer.toString()+"\n" ;
		}

		return result;
	}

	

	//http://localhost:8080/delete?id=1
	@RequestMapping("/delete")
	public String deleteById(@RequestParam("id") Long id) {
		customerRepository.delete(id);

		return "Done";
	}
}
