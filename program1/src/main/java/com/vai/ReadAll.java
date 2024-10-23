package com.vai;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class ReadAll {
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
					 
					 String hql = "From Alien";
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
				// TODO Auto-generated method stub
				for (Alien alien : aliens) {
					System.out.println(alien);
					
				}
				
			}
}
