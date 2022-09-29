package com.orthofx;



public class Employee {
	private int id;
	private String name;
	private Department dept;
	
	public Employee(int id, String name, Department dept) {
		this.id = id;
		this.name = name;
		this.dept=dept;
	}
	public int getId() {
		return id;
	}	
	public String getName() {
		return name;
	}
//	public String getDept() {
//		return dept.getName();
//	}
	public Department getDept(){
		return dept;
	}
}
