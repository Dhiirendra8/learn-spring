package com.learn.spring.repository;

import com.learn.spring.model.Accounts;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface AccountsRepository extends CassandraRepository<Accounts, Long> {
	
	Accounts findByCustomerId(int customerId);

}
