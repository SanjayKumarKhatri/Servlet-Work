package com.sqlquery;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

public class SQLExample {
	
	public static void main(String[] args) {
		
	 SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	 Session s = factory.openSession();
	 
	 //Sql query
	 String query = "Select * from Student";
	 
     NativeQuery nq = s.createSQLQuery(query);
     
     List<Object[]> list  = nq.list();
     
     for(Object[] st : list) {
    	 
    	 System.out.println(st[4]+" : "+st[3]);
    	 
    	}
	 
	 
	 
	 
	 
	 
	 s.close();
	 factory.close();
	}

}
