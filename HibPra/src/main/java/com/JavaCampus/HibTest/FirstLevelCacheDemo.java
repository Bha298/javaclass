package com.JavaCampus.HibTest;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.JavaCampus.Config.Hibernate5Utils;
import com.JavaCampus.Entity.Student;

public class FirstLevelCacheDemo {

	private static Session session = null;
	private static Transaction tx = null;
	private static Student stu = null;

	public static void cacheDemo() {

		// Get the session object from util calss

		session = Hibernate5Utils.getSession();

		tx = session.beginTransaction();

		System.out.println("================load()========================");
		stu = session.load(Student.class, new Integer(3));

		System.out.println(stu.getId() + " : " + stu.getName() + " : " + stu.getCname() + " : " + stu.getAddress());
		System.out.println("================load() First End========================");
		
		System.out.println("================load() Second Time========================");
		
		stu = session.load(Student.class, new Integer(3));
		System.out.println(stu.getId() + " : " + stu.getName() + " : " + stu.getCname() + " : " + stu.getAddress());
		System.out.println("================load() Second End========================");
		
		/*
		 * System.out.println("================get()========================"); stu =
		 * session.get(Student.class, new Integer(3)); System.out.println(stu.getId() +
		 * " : " + stu.getName() + " : " + stu.getCname() + " : " + stu.getAddress());
		 * System.out.println("================get() Second End========================"
		 * );
		 */
		

		System.out.println("================load()========================");
		stu = session.load(Student.class, new Integer(4));
		System.out.println(stu.getId() + " : " + stu.getName() + " : " + stu.getCname() + " : " + stu.getAddress());
		System.out.println("================load() First End========================");
		
		// delete selected record from the cache
		System.out.println("Before evict() check the cache :"+session.contains(stu));
		session.evict(stu);
	   //session.clear();
		
		System.out.println("After evict() check the cache :"+session.contains(stu));
		
		System.out.println("================evict()========================");
		stu = session.get(Student.class, new Integer(4));

		System.out.println(stu.getId() + " : " + stu.getName() + " : " + stu.getCname() + " : " + stu.getAddress());
		System.out.println("================evict()  End========================");
		
		tx.commit();
		session.close();
	}

	public static void main(String[] args) {

		cacheDemo();

	}

}
