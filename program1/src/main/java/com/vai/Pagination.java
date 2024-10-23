package com.vai;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class Pagination {
	
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
			
			Query query = session.createQuery("From Alien");
			query.setFirstResult(2);
			query.setMaxResults(3);
			
			List<Alien> list= query.list();
			
			
			
			tx.commit();
			
			display(list);
			
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

	private static void display(List<Alien> list) {
		// TODO Auto-generated method stub
		for (Alien alien : list) {
			System.out.println(alien);
			
		}
		
	}

}
