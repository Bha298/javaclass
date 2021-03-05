package com.JavaCampus.HibTest;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.JavaCampus.Config.Hibernate5Utils;
import com.JavaCampus.Entity.Student;

public class FetchStudent {

	private static void fetchStuRecords() {

		Student stu = null;

		// Type 1 : using get()

		// Get the Session object

		Session session = Hibernate5Utils.getSession();
		Transaction tx = session.beginTransaction();

		System.out.println("===================get()============================================================");
		stu = session.get(Student.class, new Integer(5));
		System.out.println("====================================================================================");
		System.out.println(stu.getId() + " : " + stu.getName() + " : " + stu.getCname() + " : " + stu.getAddress());
		System.out.println("====================================================================================");

		// Type 2 : using load()

		System.out.println("===================load()============================================================");

		stu = session.load(Student.class, new Integer(6));

		System.out.println("====================================================================================");
		System.out.println(stu.getId() + " : " + stu.getName() + " : " + stu.getCname() + " : " + stu.getAddress());
		System.out.println("====================================================================================");

		// Update()

		System.out.println("===================update()============================================================");

		stu = session.load(Student.class, new Integer(6));

		System.out.println("Before Updating DB Record :" + stu);

		stu.setName("Rahul");
		stu.setCname("JavaWithAngular");
		stu.setAddress("Darmavaram");
		session.update(stu);

		System.out.println("====================================================================================");

		System.out.println(
				"===================saveOrUpdate()============================================================");
		stu = session.load(Student.class, new Integer(7));

		System.out.println("Before Updating DB Record :" + stu);

		stu.setCname("SeleniumTesting");
		session.saveOrUpdate(stu);

		tx.commit();
		session.close();

	}

	public static void main(String[] args) {

		fetchStuRecords();

	}

}
