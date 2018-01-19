package com.rsfranco.callcenter.model;

public class Employee {
	
	private boolean isAvailable;
	private String name;
	
	public Employee(String name) {
		super();
		this.name = name;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
