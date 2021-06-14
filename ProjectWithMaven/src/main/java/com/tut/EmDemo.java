package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmDemo {
	
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		Student student1 = new Student();
		student1.setId(8464);
		student1.setName("Sanjay Kumar");
		student1.setCity("Hyderabad");
		
		Certificate certificate = new Certificate();
		certificate.setCourse("Java");
		certificate.setDuration("6 Month");
		student1.setCerti(certificate);
		
		Student student2 = new Student();
		student2.setId(8475);
		student2.setName("Akash Kumar");
		student2.setCity("Hyderabad");
		
		Certificate certificate1 = new Certificate();
		certificate1.setCourse("Andriod");
		certificate1.setDuration("3 Month");
		student2.setCerti(certificate1);
		
		Session s = factory.openSession();
		Transaction tx = s.beginTransaction();
		
		// Object Saves...
		
		s.save(student1);
		s.save(student2);
		
		
		tx.commit();
		s.close();
		factory.close();
	}

}
