package com.fse.menurest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fse.menurest.dao.SubjectDAO;
import com.fse.menurest.entity.Subject;



@Service
public class SubjectServiceImpl implements SubjectService{

	@Autowired
	//@Qualifier("hibernate")
	SubjectDAO subjectDao;

	public boolean addSubject(Subject subject) {
		return subjectDao.addSubject(subject);
	}

	

	public Subject getSubject(Long subjectId) {
		return subjectDao.getSubject(subjectId);
	}



	@Override
	public List<Subject> getAllSubjects() {
		return subjectDao.getAllSubjects();
	}
}

