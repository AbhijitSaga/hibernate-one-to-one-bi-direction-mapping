package com.luv2code.hibernate.demo;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.Instructor;
import com.entity.InstructorDetail;

public class HibernateUtil {

	private HibernateUtil() {
	}

  static	SessionFactory sessionFactory = null;

static	SessionFactory getSessionFectory() {
	try {
		if (sessionFactory == null) {

			

				Configuration configuration=new Configuration();
				configuration.configure("hibernate.cfg.xml");
				configuration.addAnnotatedClass(Instructor.class);
				configuration.addAnnotatedClass(InstructorDetail.class);
				 sessionFactory=configuration.buildSessionFactory();
				
		 }
	} catch (Exception e) {
		e.printStackTrace();
	}
		return sessionFactory;

	}

}
