package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.entity.Instructor;
import com.entity.InstructorDetail;

public class CreateDemo {

	public static void main(String[] args) {

		
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFectory();
		Session session=null;
		if (sessionFactory != null) {
			session = sessionFactory.getCurrentSession();
		}
		
		
		

		try {
			// create the object
			Instructor theInstructor = new Instructor("abhijit", "sagar", "abhijitsagar1204@gmail.com");

			InstructorDetail theInstructorDetail = new InstructorDetail("abhijitYouTubeChannel", "codding");

			theInstructor.setInstructorDetail(theInstructorDetail);

			// start a transaction
			session.beginTransaction();

			// save the instructor
			// associate the object
			// Note: this will also save the InstructorDetail object
			// because of cascadeType.ALL

			System.out.println("saving instructor detail");
			session.save(theInstructor);

			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done......");
		} finally {
			session.close();
		}

	}
}
