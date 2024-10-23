package com.vai;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class AggrigateSum {
	
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
			  String hql = "SELECT sum(Marks) FROM Alien";
	            Query<Long> query = session.createQuery(hql, Long.class);
	            Long sumMarks = query.uniqueResult();  // Using uniqueResult for a single result
	            tx.commit();
	            // Print the result
	            System.out.println("Sum of Marks: " + (sumMarks != null ? sumMarks : 0));
	            
			
			
			
			
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
