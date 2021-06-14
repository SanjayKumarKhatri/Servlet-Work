package com.pegination;

import org.hibernate.query.*;

import com.tut.Student;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HQLPegination {
	
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session s = factory.openSession();
		
		Query q = s.createQuery("from Student");
		
		// implementing Pegination using hibernate
		
		q.setFirstResult(0);
		q.setMaxResults(5);
		
	    List<Student> list = q.list();
	    
	    for(Student st : list) {
	    	
	    	System.out.println(st.getId()+" : "+st.getName()+" : "+st.getCity());
	    	 }
		
		
		
		s.close();
		
		factory.close();
	}

}
