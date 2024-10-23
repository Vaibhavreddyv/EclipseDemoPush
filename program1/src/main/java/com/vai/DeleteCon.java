package com.vai;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DeleteCon {
	
	
	
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
			
			String hql ="Delete from Alien A Where A.Marks>120";
			int DeletedNumRows = session.createQuery(hql).executeUpdate();
			
			tx.commit();
			System.out.println("the number of rows affected are " + DeletedNumRows);
			
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
