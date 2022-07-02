package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.Instructor;
import com.entity.InstructorDetail;

public class GetInstructorDetailDemo {

	public static void main(String[] args) {

		Session session = null;

		SessionFactory sessionFactory = HibernateUtil.getSessionFectory();

		if (sessionFactory != null) {

			session = sessionFactory.getCurrentSession();
		}
		try {
			// star a transaction
			session.beginTransaction();

			// get the instructor detail object
			int theId = 5;
			InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);

			// print the instructor detail
			System.out.println("InstructorDetail : " + tempInstructorDetail);

			// print the associated instructor
			System.out.println("the associated instructor : " + tempInstructorDetail.getInstructor());
			// commit transaction
			session.getTransaction().commit();
			System.out.println("done........!");
		} catch (Exception ex) {

			ex.printStackTrace();

		} finally {

			session.close();

		}
	}
}
