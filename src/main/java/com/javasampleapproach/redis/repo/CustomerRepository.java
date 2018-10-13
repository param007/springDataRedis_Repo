package com.javasampleapproach.redis.repo;

import java.util.Map;

import com.javasampleapproach.redis.model.Customer;

public interface CustomerRepository {

	void save(Customer customer);
	Customer find(Long id);
	Map<Long, Customer> findAll();
	
	void delete(Long id);
}
