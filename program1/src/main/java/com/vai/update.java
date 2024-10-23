package com.vai;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class update {
	
	static SessionFactory sf = null ;
	 
	 static Session session = null;
	 
	 public static void main(String[] args) {
		
	
	 
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
//		 Alien alien =  session.get(Alien.class, 101);
//		
//		 if (alien != null) {
//             // Modify the entity
//             alien.setMarks(100);
//             
//             // No need to call session.update(alien); Hibernate will automatically detect changes
//             // and update the entity when the transaction is committed.
//         } else {
//             System.out.println("Alien not found with ID 1");
//         }

		 Alien a = new Alien(111,"viji","reddy",20);
		 session.saveOrUpdate(a);
		 
		 
		 tx.commit();
	 }
	 catch (Exception e) {
		 if(session != null) {
			 session.getTransaction().rollback();}
		 e.printStackTrace();
	 }
	 finally {  
		 // closing resources
		 session.close();
		 sf.close();
		 
	 }

	 }
	 

}
