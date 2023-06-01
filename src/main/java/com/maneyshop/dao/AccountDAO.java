package com.maneyshop.dao;

import java.util.List;

import javax.management.RuntimeErrorException;
import javax.persistence.criteria.CriteriaBuilder;

import org.hibernate.query.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.CriteriaQuery;

import com.maneyshop.model.Account;
import com.maneyshop.dao.AccountDAO;
import com.maneyshop.util.HibernateUtil;
public class AccountDAO {
	/**
	 * Check login
	 * @param username, password
	 * @return true if login successful, false otherwise
	 */
	public boolean validate(String userName, String password) {
	    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	        Transaction transaction = session.beginTransaction();
	        Account account = session.createQuery("FROM Account U WHERE U.username = :userName", Account.class)
	            .setParameter("userName", userName)
	            .uniqueResult();
	        if (account != null && account.getPassword().equals(password)) {
	            transaction.commit();
	            return true;
	        }
	        transaction.rollback();
	        return false;
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}
	/**
	 * Change password
	 * @param username, oldpassword, newpassword
	 * @return true if change successful, false otherwise
	 */
	public boolean changePassword(String userName, String oldPassword, String newPassword) {
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			Account account = session.createQuery("FROM Account U WHERE U.username = :userName", Account.class)
					.setParameter("userName", userName)
					.uniqueResult();
			if(account != null && account.getPassword().equals(oldPassword)) {
				account.setPassword(newPassword);
				session.update(account);
				transaction.commit();
				return true;
			}
			transaction.rollback();
			return false;
		} catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			throw new RuntimeException(e);
		}
	}
	/**
	 * 
	 * Save Account
	 * @param Account
	 */
	public boolean saveAccount(Account account) {
	    Transaction transaction = null;
	    boolean isSuccess = false;
	    try(Session session = HibernateUtil.getSessionFactory().openSession()) {
	        // start a transaction
	        transaction = session.beginTransaction();

	        // check if the username or email already exists
	        Query query = session.createQuery("from Account where username=:username or email=:email");
	        query.setParameter("username", account.getUsername());
	        query.setParameter("email", account.getEmail());
	        List<Account> accounts = query.list();

	        if(accounts.size() > 0) {
	            // The username or email already exists, notify the user and return false.
	        	// User already exists
	        	isSuccess = false;
	            throw new RuntimeException("Username or email already existed!");
	        } else {
	            // save the account object
	            session.save(account);
//	            System.out.println("User is saved");
	            // commit transaction
	            transaction.commit();
	            isSuccess = true;
	        }
	    } catch (Exception e) {
	        if (transaction != null) {
	            transaction.rollback();
	        }
	        e.printStackTrace();
	    }
	    return isSuccess;
	}

	/**
	 * Update Account
	 * @param Account
	 */
	public void UpdateAccount(Account account) {
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			//start
			transaction = session.beginTransaction();
			//update
			session.update(account);
			System.out.println("user is updated");
			//commit
			transaction.commit();
		}catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}
	/**
	 * Delete Account
	 * @param id
	 */
	public void DeleteAccount(int id) {
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			//start
			transaction = session.beginTransaction();
			//get user to delete
			Account account = session.get(Account.class,id);
			if(account != null) {
				session.delete(account);
				System.out.println("user is deleted");
			}// commit transaction
			transaction.commit();
		}catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}
	/**
	 * Get User By username
	 * @param id
	 * @return
	 */
	public Account getAccountByUsername(String username) {
	    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	        Transaction transaction = session.beginTransaction();
	        Account account = session.createQuery("FROM Account WHERE username = :username", Account.class)
	            .setParameter("username", username)
	            .uniqueResult();
	        transaction.commit();
	        return account;
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}
	
	public Account getAccountById(int id) {
	    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	        Transaction transaction = session.beginTransaction();
	        Account account = session.createQuery("FROM Account WHERE id =:id", Account.class)
	            .setParameter("id", id)
	            .uniqueResult();
	        transaction.commit();
	        return account;
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}
	
	public Account getAccountByEmail(String email) {
	    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	        Transaction transaction = session.beginTransaction();
	        Account account = session.createQuery("FROM Account WHERE email =:email", Account.class)
	            .setParameter("email", email)
	            .uniqueResult();
	        transaction.commit();
	        return account;
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}
	
	/**
	 * Check username or email are already existed in DB
	 * @param username, email
	 * @return true | false
	 */
	
	public boolean checkUsernameAndEmail(String username, String email) {
		Transaction transaction = null;
	    try(Session session = HibernateUtil.getSessionFactory().openSession()) {
	    	//start transaction
	    	transaction = session.beginTransaction();
	    	//check usn and email
	    	Query query = session.createQuery("from Account U WHERE U.username = :username and U.email = :email");
	    			query.setParameter("username", username);
	    			query.setParameter("email", email);
	    			List<Account> accounts = query.list();
	    	transaction.commit();
	    	return accounts.size() > 0;
	    			
	    }catch (Exception e) {
	        if (transaction != null) {
	            transaction.rollback();
	        }
	        e.printStackTrace();
	    }
	    return false;
	}
	/**
	 * Check username or email are already existed in DB
	 * @param username, email
	 * @return true | false
	 */
	
	public boolean checkUserEmail(String email) {
		Transaction transaction = null;
	    try(Session session = HibernateUtil.getSessionFactory().openSession()) {
	    	//start transaction
	    	transaction = session.beginTransaction();
	    	//check usn and email
	    	Query query = session.createQuery("from Account U WHERE U.email = :email");
	    			query.setParameter("email", email);
	    			List<Account> accounts = query.list();
	    	transaction.commit();
	    	return accounts.size() > 0;
	    			
	    }catch (Exception e) {
	        if (transaction != null) {
	            transaction.rollback();
	        }
	        e.printStackTrace();
	    }
	    return false;
	}
	/**
	 * Get role of user
	 * @param username, email
	 * @return true | false
	 */
	public int getUserRoleFromDatabase(String username) {
	    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	        Transaction transaction = session.beginTransaction();
	        Account account = session.createQuery("FROM Account U WHERE U.username = :username", Account.class)
	            .setParameter("username", username)
	            .uniqueResult();
	        if (account != null) {
	            int role = account.getRole();
	            transaction.commit();
	            return role;
	        } else {
	            transaction.rollback();
	            return -1;
	        }
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}
	
	public List<Account> getAllAccounts() {
	    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	        Query<Account> query = session.createQuery("FROM Account", Account.class);
	        List<Account> accounts = query.getResultList();
	        return accounts;
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}
	
	public int getTotalAccounts() {
	    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	        Query<Number> query = session.createQuery("SELECT COUNT(*) FROM Account", Number.class);
	        Number count = query.getSingleResult();
	        return count.intValue();
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}
	public List<Account> pageAccount(int index, int pageSize) {
	    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	        Query<Account> query = session.createQuery("FROM Account", Account.class);
	        query.setFirstResult((index - 1) * pageSize);
	        query.setMaxResults(pageSize);
	        List<Account> accountList = query.getResultList();
	        return accountList;
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}
	
}