package com.vai;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Read1Data {
	
	public static void main(String[] args) {
		
	
	
	SessionFactory sf = null;
	 
	 Session session = null;
	 
	 try {
		 
		 // create session factory
		 sf = new Configuration()
				 .configure()
				 .addAnnotatedClass(Alien.class)
				 .buildSessionFactory();
		 // create session
		 session = sf.openSession();
		 
		 // create transaction			 
		 Transaction tx = session.beginTransaction();
		 
		 //CRUD operation
		 Alien a = session.get(Alien.class,108);
		System.out.println(a);
		 
		 tx.commit();
	 }
	 finally {  
		 // closing resources
		 session.close();
		 sf.close();
		 
	 }

	}
}
