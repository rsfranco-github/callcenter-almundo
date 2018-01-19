package com.rsfranco.callcenter;

import static org.junit.Assert.assertTrue;

import java.util.LinkedList;
import java.util.Queue;

import com.rsfranco.callcenter.business.Call;
import com.rsfranco.callcenter.business.Dispatcher;
import com.rsfranco.callcenter.model.Manager;
import com.rsfranco.callcenter.model.Operator;
import com.rsfranco.callcenter.model.Supervisor;

import org.junit.Test;

public class AppTest {
	
	public static int N = 10, M = 5;

	@Test
	public void test1() {
		
		//test1: 12 llamadas con 4 operadores,2 supervisores , 1 director
		
		Queue<Call> calls = new LinkedList<Call>();
		for (int i = 1; i <= 12; i++) {
			int time = (int) Math.floor(Math.random() * (N - M + 1) + M);
			calls.add(new Call(i, time));
		}

		Queue<Manager> managers = new LinkedList<Manager>();
		for (int i = 1; i <= 1; i++) {
			managers.add(new Manager(i + ""));
		}

		Queue<Supervisor> supervisors = new LinkedList<Supervisor>();
		for (int i = 1; i <= 2; i++) {
			supervisors.add(new Supervisor(i + ""));
		}

		Queue<Operator> operators = new LinkedList<Operator>();
		for (int i = 1; i <= 4; i++) {
			operators.add(new Operator(i + ""));
		}

		Dispatcher dispatcher = new Dispatcher(managers, supervisors, operators);
		
		assertTrue(dispatcher.listener(calls));
	}
	
	@Test
	public void test2() {
		
		// Test2: 8 llamadas 1 representante por empleado
		
		Queue<Call> calls = new LinkedList<Call>();
		for (int i = 1; i <= 8; i++) {
			int time = (int) Math.floor(Math.random() * (N - M + 1) + M);
			calls.add(new Call(i, time));
		}

		Queue<Manager> managers = new LinkedList<Manager>();
		for (int i = 1; i <= 1; i++) {
			managers.add(new Manager(i + ""));
		}

		Queue<Supervisor> supervisors = new LinkedList<Supervisor>();
		for (int i = 1; i <= 1; i++) {
			supervisors.add(new Supervisor(i + ""));
		}

		Queue<Operator> operators = new LinkedList<Operator>();
		for (int i = 1; i <= 1; i++) {
			operators.add(new Operator(i + ""));
		}

		Dispatcher dispatcher = new Dispatcher(managers, supervisors, operators);
		
		assertTrue(dispatcher.listener(calls));
	}

}
