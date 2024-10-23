package com.vai;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class BatchUpdate {
	
	public static void main(String[] args) {
		SessionFactory sf = null ;
		 
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
			 //Batch update
			 String hql = "UPDATE Alien A SET A.Acolor = 'Fair' where A.Aname='vaibhav'";
			 int updatedEntities = session.createQuery(hql).executeUpdate();
			 
			
			 
			 tx.commit();
			 System.out.println("The number of updated rows" +  updatedEntities);
		 }
		 catch (Exception e) {
			 if(session != null) {
				 session.getTransaction().rollback();
			 }
			 e.printStackTrace();
		 }
		 finally {  
			 // closing resources
			 session.close();
			 sf.close();
			 
		 }
	}

}
