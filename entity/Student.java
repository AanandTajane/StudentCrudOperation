package com.StudentCurdOpeartion.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
 public class Student {
	
	 @Id
	 private int rollNo;
	 private String name;
	 private String  Address;
	 private String  City;
	 
	 public Student() {
		 
	 }
	 
	public Student(int rollNo, String name, String address, String city) {
		super();
		this.rollNo = rollNo;
		this.name = name;
		Address = address;
		City = city;
	}
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		this.Address = address;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		 this.City = city;
	}
	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", name=" + name + ", Address=" + Address + ", City=" + City + "]";
	}
	 
 }
