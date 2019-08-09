package com.fse.menurest.dao;

import java.util.List;

import com.fse.menurest.entity.Subject;


public interface SubjectDAO{
	public boolean addSubject(Subject subject);
	public List<Subject> getAllSubjects();
	public Subject getSubject(Long subjectId);
}