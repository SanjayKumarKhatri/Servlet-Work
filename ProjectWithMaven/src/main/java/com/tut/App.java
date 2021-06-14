package com.tut;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "Project started" );
        
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        
        // Creating Student...
        Student std = new Student();
        std.setId(3);
        std.setName("Sanjay");
        std.setCity("Hyderabad");
        System.out.println(std);
        
        // creating object addresss class
        Address address  = new Address();
        address.setStreet("street1");
        address.setCity("Umerkot");
        address.setOpen(true);
        address.setAddedDate(new Date());
        address.setX(645.9787);
        
        //Reading Image
        FileInputStream fis = new FileInputStream("src/main/java/sanjay.jpg");
        byte[] data  = new byte[fis.available()];
        fis.read(data);
        address.setImage(data);
        
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(std);
        session.save(address);
        tx.commit();
        session.close();
        System.err.println("Done...");
        
  
    }
}
