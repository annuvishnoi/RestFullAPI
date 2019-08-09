package com.fse.menurest.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fse.menurest.entity.Book;
import com.fse.menurest.entity.Subject;
import com.fse.menurest.exception.BookNotFoundException;

@Repository
public class BookDAOImpl implements BookDAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public boolean addBook(Book book) {
		Session session= this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(book);
		return true;
	}
	@Transactional
	public boolean update(Book book) {
		Session session= this.sessionFactory.getCurrentSession();
		
		session.update(book);
		return true;
	}
	@Transactional
	public boolean delete(Long id) {
		Session session= this.sessionFactory.getCurrentSession();
		//HQL
		Query query= session.createQuery("delete from Book where bookId=:bookId");
		//set value placeholder
		query.setParameter("bookId", id);

		int n=query.executeUpdate();


		return n>0;
	}
	@Transactional
	public Book getBookById(Long id) {
		Session session= this.sessionFactory.getCurrentSession();
		Book book= session.get(Book.class, id);
		
		return book;
	}
	@Transactional
	public List<Book> getAllBooks() {
		Session session= this.sessionFactory.getCurrentSession();
		Query<Book> query= session.createQuery("from Book",Book.class); 
		List<Book> books=query.getResultList();
		return books;
	
	}

}
