package com.learn.spring.repository;

import java.util.List;

import com.learn.spring.model.Customer;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerRepository extends CassandraRepository<Customer, Long> {
	
	List<Customer> findByEmail(String email);

}
