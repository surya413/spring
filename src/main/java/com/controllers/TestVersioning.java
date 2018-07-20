package com.controllers;

import org.hibernate.SessionFactory;
import org.hibernate.StaleObjectStateException;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.pojos.Employee;

public class TestVersioning {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		
		Session session1 = sf.openSession();
		//Gautham, Model N, 1
		Employee emp1 = (Employee) session1.get(Employee.class, 2);
		emp1.setEmpName("Prasa2d");
		
		
		try {
		Session session2 = sf.openSession();
		
		Employee emp2 = (Employee) session2.get(Employee.class, 2);
		emp2.setCompany("JD323A");
		
		
		session1.beginTransaction().commit();//Raju, DBS
		
		session2.beginTransaction().commit(); // Anil, JDA
		}catch(StaleObjectStateException e) {
			throw new RuntimeException("The object is modified by other user, Kindly take the latest and update...");
		}
		
		
		/*Employee emp=new Employee();
		emp.setEmpName("Geetha");

		emp.setCompany("Model N");
		
		Session s = sf.openSession();
		s.save(emp);
		s.beginTransaction().commit();
		System.out.println("end");
*/
		
	}
}
