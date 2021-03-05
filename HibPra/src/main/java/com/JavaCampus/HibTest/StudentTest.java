package com.JavaCampus.HibTest;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.JavaCampus.Entity.Student;
import com.JavaCampus.Utils.HibernateUtils;

public class StudentTest {

	public static void main(String[] args) {

		// Get the connection

		Session session = HibernateUtils.getSession();

		Transaction tx = session.beginTransaction();

		Student stu = new Student(); // Fresh Created Object so that we can Tranient State
		stu.setName("Sindhu");
		stu.setCname("JavaFullstack");
		stu.setAddress("Kadapa");

		//Integer i = (Integer) session.save(stu);   // persist State
		
		/*
		 * if(i>0) { System.out.println("Data hasbeen inserted...!"+i); }
		 */
		//session.persist(stu); // persist State
		
		session.saveOrUpdate(stu);
		tx.commit();
		session.close();

	}

}
