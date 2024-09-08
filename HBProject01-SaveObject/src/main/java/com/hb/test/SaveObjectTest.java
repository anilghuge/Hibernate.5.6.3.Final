package com.hb.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hb.entity.Product;

public class SaveObjectTest {

	
	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure("com/hb/config/hibernate.cfg.xml");
		System.out.println(cfg.getProperties());
		SessionFactory sessionFactory=cfg.buildSessionFactory();
		System.out.println(sessionFactory.getProperties());
		Session session = sessionFactory.openSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();//internal calls con.setAutoCommit(false) : to disable autoCommit model on db s/w
			
			Product prod=new Product();
			prod.setPid(1003);
			prod.setPname("Sofa2");
			prod.setPrice(5678.5f);
			prod.setQty(1.0f);
			Integer saveId = (Integer) session.save(prod);
			System.out.println("Generated Id value :"+saveId);
			tx.commit();//internal call con.commit method insertion execution result permanent
			System.out.println("Object is saved(Record is inserted)");
			} catch (HibernateException he) {
				he.printStackTrace();
				tx.rollback(); //internally calls con.rollback() method to rollback the result of query execution
				System.out.println("Object is not saved(Record is not inserted)");				
			}finally {
				session.close();
				sessionFactory.close();
			}
		
		
	}
}
