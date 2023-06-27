package com.learn.spring.repository;

import java.util.Arrays;
import java.util.List;

import com.learn.spring.model.Notice;
import org.springframework.data.cassandra.repository.CassandraRepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface NoticeRepository extends CassandraRepository<Notice, Long> {
	
//	@Query(value = "from Notice n where CURDATE() BETWEEN noticBegDt AND noticEndDt")
	default List<Notice> findAllActiveNotices(){

        return Arrays.asList();
    }

}
