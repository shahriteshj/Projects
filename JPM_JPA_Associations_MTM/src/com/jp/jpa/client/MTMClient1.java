package com.jp.jpa.client;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;

import com.jp.jpa.entity.Course;
import com.jp.jpa.entity.Trainee;
import com.jp.jpa.util.JPAUtil;

public class MTMClient1 {

	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManager();
		
		
			
		Course c1 = new Course();
		c1.setCourseId(1L);
		c1.setCourseName("Java");
			
		
		Course c2 = new Course();
		c2.setCourseId(2L);
		c2.setCourseName("C++");
		
		
		Trainee t1 = new Trainee();
		t1.setTraineeId(1L);
		t1.setTraineeName("A");
		
		Trainee t2 = new Trainee();
		t2.setTraineeId(2L);
		t2.setTraineeName("B");
		Trainee t3 = new Trainee();
		t3.setTraineeId(3L);
		t3.setTraineeName("C");
		Trainee t4 = new Trainee();
		t4.setTraineeId(4L);
		t4.setTraineeName("D");
		Trainee t5 = new Trainee();
		t5.setTraineeId(5L);
		t5.setTraineeName("E");
		Trainee t6 = new Trainee();
		t6.setTraineeId(6L);
		t6.setTraineeName("F");
		
		Set<Trainee> trainees1 = new HashSet<Trainee>();
		trainees1.add(t1);
		trainees1.add(t2);
		trainees1.add(t3);
		trainees1.add(t4);
		trainees1.add(t5);
		trainees1.add(t6);
		
		Set<Trainee> trainees2 = new HashSet<Trainee>();
		trainees2.add(t1);
		trainees2.add(t2);
		trainees2.add(t3);
		
		
		Set<Course>courses1 = new HashSet<Course>();
		courses1.add(c1);
		courses1.add(c2);
		
		Set<Course>courses2 = new HashSet<Course>();
		courses2.add(c1);
		
		c1.setTrainees(trainees1);
		c2.setTrainees(trainees2);
		
		t1.setCourses(courses1);
		t2.setCourses(courses1);
		t3.setCourses(courses1);
		t4.setCourses(courses2);
		t5.setCourses(courses2);
		t6.setCourses(courses2);
		
		
		em.getTransaction().begin();
		em.persist(c1);
		em.persist(c2);
		em.getTransaction().commit();

	}

}
