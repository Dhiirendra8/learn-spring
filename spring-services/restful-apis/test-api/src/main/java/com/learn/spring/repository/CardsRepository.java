package com.learn.spring.repository;

import java.util.List;

import com.learn.spring.model.Cards;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CardsRepository extends CassandraRepository<Cards, Long> {
	
	List<Cards> findByCustomerId(int customerId);

}
