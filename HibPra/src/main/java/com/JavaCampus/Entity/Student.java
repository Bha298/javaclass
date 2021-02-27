package com.JavaCampus.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "s_id", nullable = false, length = 16)
	private Integer id;
	@Column(name = "s_name", nullable = false, length = 32)
	private String name;
	@Column(name = "s_course", nullable = false, length = 32)
	private String cname;
	@Column(name = "s_address", nullable = false, length = 32)
	private String address;

	public Student() {

	}

	public Student(Integer id, String name, String cname, String address) {
		super();
		this.id = id;
		this.name = name;
		this.cname = cname;
		this.address = address;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
