package com.maneyshop.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.maneyshop.model.ShippingInfo;
import com.maneyshop.util.HibernateUtil;

public class ShippingInforDAO {
	//save cart
		public void saveShippingInfo(ShippingInfo shipInfo) {
	        Transaction transaction = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            // start a transaction
	            transaction = session.beginTransaction();
	            // save the product object
	            session.save(shipInfo);
	            System.out.println("Shipping Information is saved");
	            // commit transaction
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	    }

}
