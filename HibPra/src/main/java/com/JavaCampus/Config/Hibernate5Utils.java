package com.JavaCampus.Config;

import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.JavaCampus.Entity.Student;


public class Hibernate5Utils {

	private static SessionFactory sf = null;

	public static SessionFactory getSessionFactory() {

		if (sf == null) {
			try {

				// Create object for configuration

				Configuration cfg = new Configuration();

				// Load the properties from configuration

				Properties prop = new Properties();

				prop.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
				prop.put(Environment.URL, "jdbc:mysql://localhost:3306/ums");
				prop.put(Environment.USER, "root");
				prop.put(Environment.PASS, "root");
				prop.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
				prop.put(Environment.SHOW_SQL, "true");
				prop.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
				prop.put(Environment.HBM2DDL_AUTO, "update");
				cfg.addProperties(prop);
				cfg.addAnnotatedClass(Student.class);
				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
						.applySettings(cfg.getProperties()).build();

				sf = cfg.buildSessionFactory(serviceRegistry);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sf;
	}
	
	public static Session getSession() {

		return (Hibernate5Utils.getSessionFactory() != null) ? sf.openSession() : null;

	}

	public static void main(String[] args) {

		System.out.println("Session :" + Hibernate5Utils.getSession());

	}

}
