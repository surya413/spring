package com.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.OrderBy;
import javax.persistence.criteria.Order;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.pojos.Employee;

public class TestProjections {
	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		
		Session session1 = sf.openSession();
		
		Criteria criteria = session1.createCriteria(Employee.class);
	//	criteria.add(Restrictions.eq("empName", "ANil"));
	/*	criteria.setProjection(Projections.property("company"));
		criteria.setProjection(Projections.property("empName"));
	*/	
		
		
		ProjectionList p1=Projections.projectionList();
     	p1.add(Projections.property("empName"));
        p1.add(Projections.property("company"));	
        
        
        criteria.setProjection(p1);
        criteria.add(Restrictions.eq("empName", "ANil"));
        
        
        List<Object[]> list = criteria.list();
        
        List<Employee> empList=new ArrayList<Employee>();
		for (Object[] object : list) {
			Employee emp = new Employee();

			emp.setEmpName((String) object[0]);
			emp.setCompany((String) object[1]);
			empList.add(emp);

		}
		
		for (Employee employee : empList) {
			
			System.out.println(employee.getEmpName()+" "+employee.getCompany());	
		}

        
		/*List<Object> list = criteria.list();
		
		for (Object objects : list) {
			
				
				System.out.println(objects);
		}*/
		
		/*List<Employee> list = criteria.list();
		
		for (Employee employee : list) {
			System.out.println(employee.getEmpName()+" "+employee.getCompany()+" "+employee.getEmpId());
		}*/
		/*Query query = session1.createQuery("select empName from Employee");
		List<Object> list = query.list();
		
		List<Employee> empList=new ArrayList<Employee>();
		for (Object object : list) {
			Employee emp = new Employee();

			emp.setEmpName((String) object);
			empList.add(emp);

		}
		
		for (Employee employee : empList) {
			
			System.out.println(employee.getEmpName()+" "+employee.getCompany());	
		}
		
*/		
	/*	for (Employee employee : list) {
		}
	*/	
	}
}
