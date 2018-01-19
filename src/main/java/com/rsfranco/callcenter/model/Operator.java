package com.rsfranco.callcenter.model;

public class Operator extends Employee {

	public Operator(String name) {
		super(name);
	}

	public String getName() {
		return this.getClass().getSimpleName()+" "+super.getName();
	}
	
}
