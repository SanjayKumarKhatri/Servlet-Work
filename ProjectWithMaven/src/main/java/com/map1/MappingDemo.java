package com.map1;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MappingDemo {
	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		Emp emp1 = new Emp();
		Emp emp2 = new Emp();
		
		emp1.setEid(12);
		emp1.setName("Sanjay");
		
		emp2.setEid(14);
		emp2.setName("Saqib");
		
		Project p1 = new Project();
		Project p2 = new Project();
		
		p1.setPid(45);
		p1.setProjectName("Libaray Managment System");
		
		p2.setPid(47);
		p2.setProjectName("ChatBot");
		
		List<Emp> list1 = new ArrayList<Emp>();
		List<Project> list2 = new ArrayList<Project>();
		
		list1.add(emp1);
		list1.add(emp2);
		
		list2.add(p1);
		list2.add(p2);
		 
		//
		emp1.setProjects(list2);
		p2.setEmps(list1);
		
		Session s = factory.openSession();
		Transaction tx = s.beginTransaction();
		
		s.save(emp1);
		s.save(emp2);
		s.save(p1);
		s.save(p2);
		
		tx.commit();
		s.close();
		
		
		
		
		factory.close();
	}

}
