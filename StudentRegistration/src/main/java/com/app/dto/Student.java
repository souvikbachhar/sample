package com.app.dto;

import java.math.BigInteger;

public class Student {

	private String name;
	private String dob;
	private String qualification;
	private String address;
	private Long number;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDob() {
		return dob;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", dob=" + dob + ", qualification=" + qualification + ", address=" + address
				+ ", number=" + number + "]";
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Long getNumber() {
		return number;
	}
	public void setNumber(Long number) {
		this.number = number;
	}
}
