package com.fse.menurest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fse.menurest.dao.BookDAO;
import com.fse.menurest.dao.SubjectDAO;
import com.fse.menurest.entity.Book;
import com.fse.menurest.entity.Subject;


@Service
public class BookServiceImpl implements BookService{

	@Autowired //field based DI
	//@Qualifier("hibernate")
	BookDAO bookDao;
	
	@Autowired
	//@Qualifier("hibernate")
	SubjectDAO subjectDao;
	
	@Transactional
	public boolean addBook(Book book) {
		/*Subject subject  = subjectDao.getSubject(book.getSelectedSubject());
		book.setSubject(subject);*/
		return bookDao.addBook(book);
	}
	@Transactional
	public boolean update(Book book) {
		/*Subject subject  = subjectDao.getSubject(book.getSelectedSubject());
		book.setSubject(subject);*/
		return bookDao.update(book);
	}
	@Transactional
	public boolean delete(Long id) {
		// TODO Auto-generated method stub
		return bookDao.delete(id);
	}
	@Transactional
	public Book getBookById(Long id) {
		// TODO Auto-generated method stub
		return bookDao.getBookById(id);
	}
	@Transactional
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return bookDao.getAllBooks();
	}

	

}
