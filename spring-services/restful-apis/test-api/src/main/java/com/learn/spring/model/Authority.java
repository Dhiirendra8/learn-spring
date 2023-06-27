package com.learn.spring.model;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;


@Table("authorities")
public class Authority {

//	@Id
	@PrimaryKey
//	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;

//	@ManyToOne
//	@JoinColumn(name = "customer_id")
	@Column("customer")
	private Customer customer;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
