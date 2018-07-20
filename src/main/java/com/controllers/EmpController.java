package com.controllers;

import org.hibernate.cfg.Configuration;
import org.hibernate.Session;

import com.pojos.Employee;
import com.pojos.Passport;

public class EmpController {

	public static void main(String[] args) {
		
		Session session = new Configuration().configure().buildSessionFactory().openSession();
		
		/*Passport p=(Passport) session.get(Passport.class, 102);
		
		System.out.println(p.getPassportNumber());
		System.out.println(p.getLocation());
		System.out.println(p.getEmp().getEmpName());
*/		
		Employee emp=new Employee();
		emp.setEmpName("Suresh");
		emp.setCompany("tcs");
		
		Passport p=new Passport();
		p.setPassportNumber("KKK12345");
		p.setLocation("Hyd");
		p.setEmp(emp);
		
		
		
		session.save(p);
		
		session.beginTransaction().commit();
		
		
		
		
	}
}
