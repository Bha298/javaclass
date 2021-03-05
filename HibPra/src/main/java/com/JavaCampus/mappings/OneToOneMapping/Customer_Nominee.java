package com.JavaCampus.mappings.OneToOneMapping;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cust_nominee")
public class Customer_Nominee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "nom_id")
	private Integer nominee_id;
	@Column(name = "nom_name")
	private String nominee_name;
	@Column(name = "nom_relation")
	private String nominee_relation;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cust_id")
	private Customer_Policy cust_policy;

	public Customer_Nominee() {

	}

	public Integer getNominee_id() {
		return nominee_id;
	}

	public void setNominee_id(Integer nominee_id) {
		this.nominee_id = nominee_id;
	}

	public String getNominee_name() {
		return nominee_name;
	}

	public void setNominee_name(String nominee_name) {
		this.nominee_name = nominee_name;
	}

	public String getNominee_relation() {
		return nominee_relation;
	}

	public void setNominee_relation(String nominee_relation) {
		this.nominee_relation = nominee_relation;
	}

	public Customer_Policy getCust_policy() {
		return cust_policy;
	}

	public void setCust_policy(Customer_Policy cust_policy) {
		this.cust_policy = cust_policy;
	}

	
	

}
