package com.controllers;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.pojos.Employee;

public class NativeSqlQueries {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session1 = sf.openSession();
		
		SQLQuery sqlQuery = session1.createSQLQuery("select * from employee");
		
		List<Object[]> list = sqlQuery.list();
		
		for (Object[] objects : list) {
			for (Object object : objects) {
				System.out.println(object);
			}
		}
		/*sqlQuery.addEntity(Employee.class);
		
		List<Employee> list = sqlQuery.list();
		
		for (Employee employee : list) {
			System.out.println(employee.getCompany()+" "+employee.getEmpName());
		}
*/
	}
}
