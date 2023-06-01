package com.maneyshop.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.maneyshop.model.Account;
import com.maneyshop.model.Cart;
import com.maneyshop.model.LineItem;
import com.maneyshop.model.Order;
import com.maneyshop.model.Product;
import com.maneyshop.model.ShippingInfo;

/**
 * Java based configuration
 * @author ramesh Fadatare
 *
 */
public class HibernateUtil {
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				Configuration configuration = new Configuration();

				// Hibernate settings equivalent to hibernate.cfg.xml's properties
				Properties settings = new Properties();
				settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
			    settings.put(Environment.URL, "jdbc:mysql://us-cdbr-east-06.cleardb.net/heroku_c2edca59c90a95c?useSSL=false");
			    settings.put(Environment.USER, "bced28b4afdd2e");
			    settings.put(Environment.PASS, "202b637f");
				settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");

				settings.put(Environment.SHOW_SQL, "true");

                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

                settings.put(Environment.HBM2DDL_AUTO, "update");

                configuration.setProperties(settings);
                configuration.addAnnotatedClass(Account.class);
                configuration.addAnnotatedClass(Product.class);
                configuration.addAnnotatedClass(LineItem.class);
                configuration.addAnnotatedClass(Cart.class);
                configuration.addAnnotatedClass(ShippingInfo.class);
                configuration.addAnnotatedClass(Order.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();
                System.out.println("Hibernate Java Config serviceRegistry created");
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
                return sessionFactory;

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sessionFactory;
	}
}