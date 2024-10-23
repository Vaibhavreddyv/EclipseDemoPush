package com.vai;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class WhereCon1 {
	
	
	public static void main(String[] args) {
		
		SessionFactory sf = null;
		
		Session session =null;
		
		try {
			
			sf = new  Configuration()
					.configure()
					.addAnnotatedClass(Alien.class)
					.buildSessionFactory();
			session = sf.openSession();
			
			Transaction tx = session.beginTransaction();
			
			String hql = "From Alien A where A.Marks>100 and A.Aname like 'v%'";
			
			Query<Alien> query = session.createQuery(hql, Alien.class);
			
			List<Alien> Aliens = query.list();
			 
			 display(Aliens);
			 
			 tx.commit();
		 }catch (Exception e) {
	            if (session != null) {
	                session.getTransaction().rollback();
	            }
	            e.printStackTrace();
	        } 
		 finally {  
			 // closing resources
			 if (session != null) {
	                session.close();
	            }
	            if (sf != null) {
	                sf.close();
	            }
				
			
		
	}

}

	private static void display(List<Alien> aliens) {
		for (Alien alien : aliens) {
			System.out.println(alien);
			
		}
	}
		// TODO Auto-generated method stub
		
	}
