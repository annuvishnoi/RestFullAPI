package com.fse.menurest.services;

import java.util.List;

import com.fse.menurest.entity.Book;

public interface BookService {
	public boolean addBook(Book book);
	public boolean update(Book book);
	public boolean delete(Long id);
	public Book getBookById(Long id);
	public List<Book> getAllBooks();

}
