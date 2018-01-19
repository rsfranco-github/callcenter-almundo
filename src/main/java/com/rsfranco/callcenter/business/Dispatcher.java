package com.rsfranco.callcenter.business;

import java.util.Queue;

import com.rsfranco.callcenter.model.Manager;
import com.rsfranco.callcenter.model.Operator;
import com.rsfranco.callcenter.model.Supervisor;

public class Dispatcher {

	private Queue<Manager> managers;
	private Queue<Supervisor> supervisors;
	private Queue<Operator> operators;

	public Dispatcher(Queue<Manager> managers, Queue<Supervisor> supervisors, Queue<Operator> operators) {
		super();
		this.managers = managers;
		this.supervisors = supervisors;
		this.operators = operators;
	}

	public Queue<Manager> getManagers() {
		return managers;
	}

	public void setManagers(Queue<Manager> managers) {
		this.managers = managers;
	}

	public Queue<Supervisor> getSupervisors() {
		return supervisors;
	}

	public void setSupervisors(Queue<Supervisor> supervisors) {
		this.supervisors = supervisors;
	}

	public Queue<Operator> getOperators() {
		return operators;
	}

	public void setOperators(Queue<Operator> operators) {
		this.operators = operators;
	}

	public boolean listener(Queue<Call> calls) {

		// Mientras existan llamada en cola
		while (!calls.isEmpty()) {
			dispatchCall(calls);
		}

		return true;
	}

	public void dispatchCall(Queue<Call> calls) {

		// si hay operadores disponibles
		if (!this.operators.isEmpty()) {

			Operator operator = this.operators.poll();
			Call incomingCall = calls.poll();

			// se ocupa ese operador en atender la llamada
			operator.setAvailable(false);
			incomingCall.setEmployee(operator);
			incomingCall.setDispatcher(this);

			incomingCall.start();

			// si hay supervisores disponibles
		} else if (!this.supervisors.isEmpty()) {

			Supervisor supervisor = this.supervisors.poll();
			Call incomingCall = calls.poll();

			// se ocupa ese supervisor en atender la llamada
			supervisor.setAvailable(false);
			incomingCall.setEmployee(supervisor);
			incomingCall.setDispatcher(this);

			incomingCall.start();

			// si hay director disponible
		} else if (!this.managers.isEmpty()) {

			Manager manager = this.managers.poll();
			Call incomingCall = calls.poll();

			// se ocupa ese director en atender la llamada
			manager.setAvailable(false);
			incomingCall.setEmployee(manager);
			incomingCall.setDispatcher(this);

			incomingCall.start();

		} else {
			// la llamada espera en cola para ser atendida
			
			System.out.println("Siga en linea su llamada sera atendida pronto...");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
