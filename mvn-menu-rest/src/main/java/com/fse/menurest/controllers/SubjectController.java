package com.fse.menurest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fse.menurest.entity.Subject;

import com.fse.menurest.exception.BookException;
import com.fse.menurest.exception.BookNotFoundException;
import com.fse.menurest.services.SubjectService;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:4200")
public class SubjectController {

	@Autowired
	SubjectService subjectService;
	
	@PostMapping("/subjects")
	public Subject addSubject(@RequestBody Subject subject){
		
		if(!this.subjectService.addSubject(subject)) {
			throw new BookException("Cannot add new Subject!!!");
		}
		return subject;
	}
	@GetMapping("/subjects")
	public List<Subject> getSubjects(){
		List<Subject> subjects=this.subjectService.getAllSubjects();
		
		if(subjects==null || subjects.isEmpty()) {
			throw new BookNotFoundException("No Subject Records not Found!!!");
		}
		return subjects;
	}
}
