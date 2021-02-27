package com.JavaCampus.Utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtils {

	private static StandardServiceRegistry registry = null;
	private static SessionFactory sf = null;

	public static SessionFactory getSessionFactory() {

		try {
			// create registry
			registry = new StandardServiceRegistryBuilder().configure().build();
			// Create a metadata sources using the specified service registry.
			MetadataSources metaDataSource = new MetadataSources(registry);

			Metadata metaData = metaDataSource.getMetadataBuilder().build();

			sf = metaData.getSessionFactoryBuilder().build();
		} catch (Exception e) {

			e.printStackTrace();
			if (registry != null) {
				StandardServiceRegistryBuilder.destroy(registry);
			}
		}
		return sf;
	}

	public static Session getSession() {

		return (HibernateUtils.getSessionFactory() != null) ? sf.openSession() : null;

	}

	public static void main(String[] args) {

		System.out.println("Session :" + HibernateUtils.getSession());

	}

}
