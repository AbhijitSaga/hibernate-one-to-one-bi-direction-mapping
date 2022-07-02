package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.entity.InstructorDetail;

public class DeleteInstructorDetail {

	public static void main(String[] args) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFectory();

		Session session = null;
		if (sessionFactory != null) {

			session = sessionFactory.getCurrentSession();

		}

		try {
			session.beginTransaction();

			int theId = 7;
			//get the instructor detail
			InstructorDetail instructorDetail=session.get(InstructorDetail.class, theId);
			//print the associated instructor
			System.out.println("the associated instructor: "+instructorDetail.getInstructor());
			//now let's delete the instructor detail
			System.out.println("instructorDetail is deleted : "+instructorDetail);

			//remove the  associated object reference
			//break bi-direction link
			instructorDetail.getInstructor().setInstructorDetail(null);
			
			session.delete(instructorDetail);//delete there
			
			session.getTransaction().commit();

		} catch (Exception ex) {

			ex.printStackTrace();
		} finally {
			session.close();
		}

	}

}
