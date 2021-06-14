package com.states;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tut.Certificate;
import com.tut.Student;

public class StateDemo {

	public static void main(String[] args) {
		
		//Paratical of Hibernate Object States:
		//Trasient
		//Persistent
		//Detached
		//Removed
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory =  cfg.buildSessionFactory();
		 
		// Create Student Object:
		Student student = new Student();
		student.setId(236);
		student.setName("Saqib");
		student.setCity("Umerkot");
		student.setCerti(new Certificate("Andriod Course","4 Months"));
		
		
		Student student1 = new Student();
		student1.setId(239);
		student1.setName("Sanjay");
		student1.setCity("Umerkot");
		student1.setCerti(new Certificate("Java Course","7 Months"));
		//Student: Trasient
		  
		Session s = factory.openSession();
		Transaction tx = s.beginTransaction();
		s.save(student);
		s.save(student1);
		//Student : Persistent - Session,database
		// student.setName("Akash");
		 
		tx.commit();
		
		s.close();
		//Student: Detached
		student.setName("Saqib");
		
		System.out.println(student);
		
		
		
		
		factory.close();
	}
				
}
