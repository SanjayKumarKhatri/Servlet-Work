package com.cascade;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.map.Answer;
import com.map.Question;

public class CascadeExample {
	
	public static void main(String[] args) {
	
	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	Session s = factory.openSession();
	
	Question q  =new Question();
	q.setQuestionId(2303);
	q.setQuestion("What is Swing framework ?");
	
	Answer a1  = new Answer(2367, "use for Development");
	Answer a2  = new Answer(2598, "Desktop ");
	Answer a3  = new Answer(2945, "learn for programmer");
	List<Answer> list = new ArrayList<Answer>();
	
	list.add(a1);
	list.add(a2);
	list.add(a3);
	q.setAnswer(list);
	
	Transaction tx = s.beginTransaction();
	s.save(q);
	
	tx.commit();
	s.close();
	factory.close();	
		
		
	}
	

}
