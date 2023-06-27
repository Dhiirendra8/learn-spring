package com.learn.spring.model;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.sql.Date;

//@Entity
@Table("loans")
public class Loans {
	
//	@Id
	@PrimaryKey
//	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column("loan_number")
	private int loanNumber;
	
	@Column("customer_id")
	private int customerId;
	
	@Column("start_dt")
	private Date startDt;
	
	@Column("loan_type")
	private String loanType;
	
	@Column("total_loan")
	private int totalLoan;
	
	@Column("amount_paid")
	private int amountPaid;
	
	@Column("outstanding_amount")
	private int outstandingAmount;
	
	@Column("create_dt")
	private String createDt;

	public int getLoanNumber() {
		return loanNumber;
	}

	public void setLoanNumber(int loanNumber) {
		this.loanNumber = loanNumber;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public Date getStartDt() {
		return startDt;
	}

	public void setStartDt(Date startDt) {
		this.startDt = startDt;
	}

	public String getLoanType() {
		return loanType;
	}

	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	public int getTotalLoan() {
		return totalLoan;
	}

	public void setTotalLoan(int totalLoan) {
		this.totalLoan = totalLoan;
	}

	public int getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(int amountPaid) {
		this.amountPaid = amountPaid;
	}

	public int getOutstandingAmount() {
		return outstandingAmount;
	}

	public void setOutstandingAmount(int outstandingAmount) {
		this.outstandingAmount = outstandingAmount;
	}

	public String getCreateDt() {
		return createDt;
	}

	public void setCreateDt(String createDt) {
		this.createDt = createDt;
	}
	
}
