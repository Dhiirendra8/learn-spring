package com.learn.spring.repository;

import java.util.List;

import com.learn.spring.model.Loans;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LoanRepository extends CassandraRepository<Loans, Long> {
	
	List<Loans> findByCustomerIdOrderByStartDtDesc(int customerId);

}
