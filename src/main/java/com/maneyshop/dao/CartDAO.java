package com.maneyshop.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.maneyshop.model.Cart;
import com.maneyshop.util.HibernateUtil;

public class CartDAO {
	//save cart
	public void saveCart(Cart cart) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the product object
            session.save(cart);
            System.out.println("Cart is saved");
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
