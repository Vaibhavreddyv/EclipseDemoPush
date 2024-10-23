package com.vai;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


public class AggAvg {




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
			
			String hql = "Select avg(Marks) From Alien";
			Query<Double> query = session.createQuery(hql,Double.class);
			Double avgMarks = query.uniqueResult();
			
			tx.commit();
			System.out.println("The minMarks is "+(avgMarks != null ? avgMarks : 0));
			
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



