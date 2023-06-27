package com.learn.spring.repository;

import com.learn.spring.model.Contact;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ContactRepository extends CassandraRepository<Contact, Long> {
	
	
}
