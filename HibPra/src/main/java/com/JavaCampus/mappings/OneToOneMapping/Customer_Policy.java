package com.JavaCampus.mappings.OneToOneMapping;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cust_policy")
public class Customer_Policy implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cust_id")
	private Integer cust_id;
	@Column(name = "cust_namr")
	private String cust_name;
	@Column(name = "cust_reg_date")
	private Date cust_reg_date;
	@Column(name = "cust_premium")
	private String cust_pay_premium;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "cust_policy" , fetch = FetchType.LAZY)
	private Customer_Nominee cust_nominee;

	public Customer_Policy() {

	}

	public Customer_Nominee getCust_nominee() {
		return cust_nominee;
	}

	public void setCust_nominee(Customer_Nominee cust_nominee) {
		this.cust_nominee = cust_nominee;
	}

	public Integer getCust_id() {
		return cust_id;
	}

	public void setCust_id(Integer cust_id) {
		this.cust_id = cust_id;
	}

	public String getCust_name() {
		return cust_name;
	}

	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}

	public Date getCust_reg_date() {
		return cust_reg_date;
	}

	public void setCust_reg_date(Date cust_reg_date) {
		this.cust_reg_date = cust_reg_date;
	}

	public String getCust_pay_premium() {
		return cust_pay_premium;
	}

	public void setCust_pay_premium(String cust_pay_premium) {
		this.cust_pay_premium = cust_pay_premium;
	}

	

}
