package com.rsfranco.callcenter.business;

import com.rsfranco.callcenter.model.Employee;
import com.rsfranco.callcenter.model.Manager;
import com.rsfranco.callcenter.model.Operator;
import com.rsfranco.callcenter.model.Supervisor;

public class Call extends Thread {
	
	private int i;
	private int time;
	private Employee employee;
	private Dispatcher dispatcher;
	
	public Call(int i,int time) {
		this.i=i;
		this.time=time;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Dispatcher getDispatcher() {
		return dispatcher;
	}

	public void setDispatcher(Dispatcher dispatcher) {
		this.dispatcher = dispatcher;
	}

	@Override
	public void run() {
		try {
			//buscamos el nombre del empleado
			String name=this.getNameEmployee();
			
			System.out.println("Atendiendo la llamada "+i+" ("+time+"seg) por "+name);
			
			//simulamos atencion de la llamada con el empleado atendiendola
			Thread.sleep(time*1000);
			System.out.println("Finalizo la llamada "+i+" ("+time+"seg) por "+name);
			
			//se libera al empleado, y se agrega a la cola de disponibles
			this.employedFree();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	
	public void employedFree() {
		if(this.employee instanceof Manager) {
			this.dispatcher.getManagers().add((Manager)this.employee);
		}else if(this.employee instanceof Supervisor) {
			this.dispatcher.getSupervisors().add((Supervisor)this.employee);
		}else if(this.employee instanceof Operator) {
			this.dispatcher.getOperators().add((Operator)this.employee);
		}
	}
	
	public String getNameEmployee() {
		String name=null;
		if(this.employee instanceof Manager) {
			name=((Manager)this.employee).getName();
		}else if(this.employee instanceof Supervisor) {
			name=((Supervisor)this.employee).getName();
		}else if(this.employee instanceof Operator) {
			name=((Operator)this.employee).getName();
		}
		return name;
	}

}
