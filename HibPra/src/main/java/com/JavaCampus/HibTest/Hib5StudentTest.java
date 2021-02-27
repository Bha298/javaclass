package com.JavaCampus.HibTest;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.JavaCampus.Config.Hibernate5Utils;
import com.JavaCampus.Entity.Student;

public class Hib5StudentTest {

	public static void main(String[] args) {
		
		Session session = Hibernate5Utils.getSession();
		Transaction tx = session.beginTransaction();

		Student stu = new Student();
		stu.setName("Madhurima");
		stu.setCname("JavaFullstack");
		stu.setAddress("Kadapa");

		session.save(stu);
		tx.commit();
		session.close();

	}

}
