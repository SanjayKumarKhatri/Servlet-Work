package com.hql;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.hibernate.query.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tut.Student;

public class HQLExample {
	
	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		Session s = factory.openSession();
		
		//HQL 
		//Syntax
		
		String query = "from Student as s where s.city=:x and s.name=:n";
		
		Query q = s.createQuery(query);
		
		q.setParameter("x", "umerkot");
		q.setParameter("n", "sanjay");
		
		//Single-(Unique)
		//Multiple-List
		List<Student> list = q.list();
		
		for(Student student : list )
		{
			System.out.println(student.getName()+" : "+student.getCerti().getCourse());
			
		} 
		
		System.out.println("____________________________________________________________");
		
		Transaction tx = s.beginTransaction();
		
		// Detete Query:
	  /*Query q2 = s.createQuery("delete from Student s where s.city=:c");
		q2.setParameter("c", "umerkot");
		
		int r = q2.executeUpdate();
		
		System.out.println("Delete:");
		System.out.println(r);*/
		
		// Update Query :
		Query q2 = s.createQuery("update Student set city=:c where name=:n");
		q2.setParameter("c", "Umerkot");
		q2.setParameter("n", "Akash");
		
		int r = q2.executeUpdate();
		System.out.println(r + " Object Updates");
		
		tx.commit();
		
		// how to execute join Query
		
	    Query q3 = s.createQuery("select q.question,q.questionId,a.answer from Question as q INNER JOIN q.answer as a");
		List<Object[]> list3 = q3.getResultList();
		
		for(Object[] arr : list3) {
			
			System.out.println(Arrays.toString(arr));
			
			}
		
		
		
		s.close();
		factory.close();
	}

}
