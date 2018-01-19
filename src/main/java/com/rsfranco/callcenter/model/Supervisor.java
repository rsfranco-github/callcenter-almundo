package com.rsfranco.callcenter.model;

public class Supervisor extends Employee {

	public Supervisor(String name) {
		super(name);
	}

	public String getName() {
		return this.getClass().getSimpleName()+" "+super.getName();
	}
}
