package com.maneyshop.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.maneyshop.model.Order;
import com.maneyshop.model.Product;
import com.maneyshop.util.HibernateUtil;

public class OrderDAO {
	//save order
	public void saveOrder(Order order) {
	    Transaction transaction = null;
	    Session session = HibernateUtil.getSessionFactory().openSession();
	    
	    try {
	        transaction = session.beginTransaction();
	        session.save(order);
	        System.out.println("Order is saved");
	        transaction.commit();
	    } catch (Exception e) {
	        if (transaction != null) {
	            transaction.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	}
	public int getTotalOrder() {
	    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	        Query<Number> query = session.createQuery("SELECT COUNT(*) FROM Order", Number.class);
	        Number count = query.getSingleResult();
	        return count.intValue();
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}
	
	public List<Order> loadPageOrder (int index, int pageSize){
		EntityManager em = HibernateUtil.getSessionFactory().createEntityManager();
		String query = "FROM Order";
		TypedQuery<Order> q = em.createQuery(query, Order.class);
		
		try {
			q.setFirstResult((index - 1) * pageSize);
	        q.setMaxResults(pageSize);
			 List<Order> orderList = q.getResultList();

			 return orderList;
		}
		catch (NoResultException e){
			return null;
		} finally {
			em.close();
		}
	}
	
	public void updateStatus(Order order) {
		 Transaction transaction = null;
	        
	        
	        try (Session session =HibernateUtil.getSessionFactory().openSession()) {
	            // start a transaction
	            transaction = session.beginTransaction();
	            // update the product object
	            session.update(order);
	            // commit transaction
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	}
	
	public Order getOrderbyID (int id) {
		EntityManager em = HibernateUtil.getSessionFactory().createEntityManager();
		String query = "FROM Order o WHERE o.id = :oID";
		TypedQuery<Order> q = em.createQuery(query, Order.class);
		q.setParameter("oID", id);
		try {
			 Order order = q.getSingleResult();
			 return order;
		}
		catch (NoResultException e){
			return null;
		} finally {
			em.close();
		}	
	}
}
