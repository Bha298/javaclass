package com.JavaCampus.HibTest;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.beanvalidation.HibernateTraversableResolver;

import com.JavaCampus.Config.Hibernate5Utils;
import com.JavaCampus.Utils.DateUtils;
import com.JavaCampus.mappings.OneToOneMapping.Customer_Nominee;
import com.JavaCampus.mappings.OneToOneMapping.Customer_Policy;

public class OneToOneTest {

	private static void saveEntity() {
		// Get the session object

		Session session = Hibernate5Utils.getSession();

		Transaction tx = session.beginTransaction();

		Customer_Policy policy = new Customer_Policy();
		policy.setCust_name("Vamsi");
		policy.setCust_pay_premium("38000");
		policy.setCust_reg_date(DateUtils.parsestrDateToSqlDate("2018-09-29"));

		Customer_Nominee nominee = new Customer_Nominee();

		nominee.setNominee_name("VamsiMother");
		nominee.setNominee_relation("Mother");
		nominee.setCust_policy(policy);

		policy.setCust_nominee(nominee);

		session.save(policy);
		tx.commit();
		session.close();

	}

	private static void selectEntity() {
		
		//Get the session
		
		Session session = Hibernate5Utils.getSession();

		Transaction tx = session.beginTransaction();
		
		Customer_Policy policy = session.load(Customer_Policy.class, new Integer(12));
		
		System.out.println("===========================================================================");
		
		System.out.println(policy.getCust_id() + " : " + policy.getCust_name() + " : " + policy.getCust_pay_premium() + " : " + policy.getCust_reg_date() + " : " + policy.getCust_nominee().getNominee_id() + " : " +policy.getCust_nominee().getNominee_name());
		
		
		System.out.println("======================HQL===================================================");
		
		List<Customer_Policy> policyList = session.createQuery("FROM Customer_Policy").list();
		
		for(Customer_Policy policy1 : policyList) {
			System.out.println(policy1.getCust_id() + " : " + policy1.getCust_name() + " : " + policy1.getCust_pay_premium() + " : " + policy1.getCust_reg_date() + " : " + policy1.getCust_nominee().getNominee_id() + " : " +policy1.getCust_nominee().getNominee_name());
		}
		tx.commit();
		session.close();
		
	}
	public static void main(String[] args) {

		//saveEntity();
		selectEntity();

	}


}
