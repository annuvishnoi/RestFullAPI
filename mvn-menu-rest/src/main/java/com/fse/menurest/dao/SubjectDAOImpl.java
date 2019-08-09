package com.fse.menurest.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fse.menurest.entity.Subject;



@Repository
public class SubjectDAOImpl implements SubjectDAO {
	@Autowired
	private SessionFactory sessionFactory;
	@Transactional
	public boolean addSubject(Subject subject) {
		Session session= this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(subject);
		return true;
	}
	@Transactional
	public List<Subject> getAllSubjects() {
		Session session= this.sessionFactory.getCurrentSession();
		Query<Subject> query= session.createQuery("from Subject",Subject.class); 
		List<Subject> subjects=query.getResultList();
		return subjects;
	}

	@Transactional
	public Subject getSubject(Long subjectId) {
		Session session= this.sessionFactory.getCurrentSession();
		Subject subject= session.get(Subject.class, subjectId);
		return subject;
	}

}
