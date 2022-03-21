package com.example.demo;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Students")
public class Student {
	@Id
	
	private int id;
	private String name;
	private String email;
	
	/**
	 * @param id
	 * @param name
	 * @param email
	 */
	public Student() {}
	public Student(int id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
