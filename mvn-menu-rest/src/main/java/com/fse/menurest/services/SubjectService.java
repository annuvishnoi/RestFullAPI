package com.fse.menurest.services;

import java.util.List;

import com.fse.menurest.entity.Subject;

public interface SubjectService {
	public boolean addSubject(Subject subject);
	public Subject getSubject(Long subjectId);
	public List<Subject> getAllSubjects();
}
