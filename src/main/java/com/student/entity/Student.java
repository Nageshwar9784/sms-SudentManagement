package com.student.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {
	@Id
	String kodId;
	
	String sname;
	
	String branch;

	public Student(String kodId, String sname, String branch) {
		super();
		this.kodId = kodId;
		this.sname = sname;
		this.branch = branch;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getKodId() {
		return kodId;
	}

	public void setKodId(String kodId) {
		this.kodId = kodId;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	@Override
	public String toString() {
		return "Student [kodId=" + kodId + ", sname=" + sname + ", branch=" + branch + "]";
	}

	

}

