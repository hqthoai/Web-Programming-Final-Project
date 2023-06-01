package com.maneyshop.dao;


import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.maneyshop.model.Product;
import com.maneyshop.util.HibernateUtil;




public class ProductDAO{

	//save product
	public void saveProduct(Product product) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the product object
            session.save(product);
            System.out.println("Product is saved");
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
	
	
	//update product
	public void updateProduct(Product product) {
        Transaction transaction = null;
        
        
        try (Session session =HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // update the product object
            session.update(product);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
	
	//get all products
	
    public List < Product > getAllProduct() {

        EntityManager em = HibernateUtil.getSessionFactory().createEntityManager();
		String query = "FROM Product";
		TypedQuery<Product> q = em.createQuery(query, Product.class);
		try {
			 List<Product> productList = q.getResultList();

			 return productList;
		}
		catch (NoResultException e){
			return null;
		} finally {
			em.close();
		}	
	
        
    }
	public Product getProductbyID (String id) {
		EntityManager em = HibernateUtil.getSessionFactory().createEntityManager();
		String query = "FROM Product p WHERE p.productID = :pID";
		TypedQuery<Product> q = em.createQuery(query, Product.class);
		q.setParameter("pID", id);
		try {
			 Product product = q.getSingleResult();
			 return product;
		}
		catch (NoResultException e){
			return null;
		} finally {
			em.close();
		}	
	}
	
	public List<Product> getProductbySellID (String id){
		EntityManager em = HibernateUtil.getSessionFactory().createEntityManager();
		String query = "FROM Product p WHERE p.sellerID = :sellID";
		TypedQuery<Product> q = em.createQuery(query, Product.class);
		q.setParameter("sellID", id);
		try {
			 List<Product> productList = q.getResultList();

			 return productList;
		}
		catch (NoResultException e){
			return null;
		} finally {
			em.close();
		}	
	}
	
	public int getTotalProduct() {
	    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	        Query<Number> query = session.createQuery("SELECT COUNT(*) FROM Product", Number.class);
	        Number count = query.getSingleResult();
	        return count.intValue();
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}
	public int getTotalProductbySellID(String sID) {
	    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	        Query<Number> query = session.createQuery("SELECT COUNT(*) FROM Product p WHERE p.sellerID = :sellID", Number.class);
	        query.setParameter("sellID", sID);
	        Number count = query.getSingleResult();
	        return count.intValue();
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}
	
	public List<Product> pageProduct(int index, int pageSize) {
		EntityManager em = HibernateUtil.getSessionFactory().createEntityManager();
		String query = "FROM Product";
		TypedQuery<Product> q = em.createQuery(query, Product.class);
		try {
			q.setFirstResult((index - 1) * pageSize);
	        q.setMaxResults(pageSize);
			 List<Product> productList = q.getResultList();

			 return productList;
		}
		catch (NoResultException e){
			return null;
		} finally {
			em.close();
		}
	}
	public List<Product> pageProductbySellID(int index, int pageSize, String sID) {
		EntityManager em = HibernateUtil.getSessionFactory().createEntityManager();
		String query = "FROM Product p WHERE p.sellerID = :sellID";
		TypedQuery<Product> q = em.createQuery(query, Product.class);
		q.setParameter("sellID", sID);
		try {
			q.setFirstResult((index - 1) * pageSize);
	        q.setMaxResults(pageSize);
			 List<Product> productList = q.getResultList();

			 return productList;
		}
		catch (NoResultException e){
			return null;
		} finally {
			em.close();
		}
	}
	
	//delete product
	public void deleteProduct(String id) {

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            // Delete a user object
            Product product = session.get(Product.class, id);
            if (product != null) {
                session.delete(product);
                System.out.println("product is deleted");
            }
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
