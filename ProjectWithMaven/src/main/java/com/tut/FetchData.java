package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchData {

	public static void main(String[] args) {
		
	Configuration cfg = new Configuration();
	cfg.configure("hibernate.cfg.xml");
	SessionFactory factory = cfg.buildSessionFactory();
	Session session = factory.openSession();
	
	Student student = (Student) session.load(Student.class, 3);
	System.out.println(student);
	
	//Address address = (Address) session.get(Address.class, 1);
	//System.out.println(address.getStreet()+ " : "+address.getCity());
	
	
	session.close();
	factory.close();
	
}
}
