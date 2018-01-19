package com.rsfranco.callcenter.model;

public class Manager extends Employee {

	public Manager(String name) {
		super(name);
	}
	
	public String getName() {
		return this.getClass().getSimpleName()+" "+super.getName();
	}

}
