package com.firstcache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tut.Student;

public class FirstDemo {
	
	public static void main(String[] args) {
		SessionFactory factory  = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		
		// ByDefault Enable.....
		Student std = session.get(Student.class, 1);
		System.out.println(std);
		
		System.out.println("Student is working....");
		
		Student std2 = session.get(Student.class, 1);
		System.out.println(std2);
		
		
		System.out.println(session.contains(std2));
		
		session.close();
		
		
		
		
		
		factory.close();
}
}
