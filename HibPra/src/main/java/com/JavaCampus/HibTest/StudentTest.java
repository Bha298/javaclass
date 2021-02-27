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

		Student stu = new Student();
		stu.setName("Prasanna");
		stu.setCname("JavaFullstack");
		stu.setAddress("Kadapa");

		session.save(stu);
		tx.commit();
		session.close();

	}

}
