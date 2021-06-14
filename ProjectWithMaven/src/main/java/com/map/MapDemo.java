package com.map;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {
	
	public static void main(String[] args) {
	
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		//Creating Question
		/*Question question = new Question();
		question.setQuestionId(1212);
		question.setQuestion("What is Java?");
		
		//Creating Answer
		Answer answer = new Answer();
		answer.setAnswerId(234);
		answer.setAnswer("Java is Programming language");
		answer.setQuestion(question);
		
		//Creating Answer
		Answer answer1 = new Answer();
		answer1.setAnswerId(235);
		answer1.setAnswer("With the help of java we will create software");
		answer1.setQuestion(question);
		
		//Creating Answer
		Answer answer2 = new Answer();
		answer2.setAnswerId(236);
		answer2.setAnswer("java has different type of framework.");
		answer2.setQuestion(question);
		
		List<Answer> list = new ArrayList<Answer>();
		list.add(answer);
		list.add(answer1);
		list.add(answer2);
		question.setAnswer(list);*/
		
		//Session
		Session s = factory.openSession();
		Transaction tx = s.beginTransaction();
		
		
		Question newQuestion = (Question) s.get(Question.class, 1212);
		
		System.out.println(newQuestion.getQuestionId());
		System.out.println(newQuestion.getQuestion());
		
		//Lazy
		System.out.println(newQuestion.getAnswer().size());
		
		
		
		
		
		// Save
		/*s.save(question);
		s.save(answer);
		s.save(answer1);
		s.save(answer2);*/
		
		tx.commit();
		
		// featching.............
		
		/*Question newQuestion = (Question) s.get(Question.class, 1212);
		System.out.println(newQuestion.getQuestion());
		System.err.println(newQuestion.getAnswer().getAnswer());
		*/
		
		s.close();
		
		
		
		
		factory.close();
		
	}

}
