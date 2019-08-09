package com.fse.menurest.dao;

import java.util.List;

import com.fse.menurest.entity.Book;

public interface BookDAO  {
	public boolean addBook(Book book);
	public boolean update(Book book);
	public boolean delete(Long id);
	public Book getBookById(Long id);
	public List<Book> getAllBooks();
	
}