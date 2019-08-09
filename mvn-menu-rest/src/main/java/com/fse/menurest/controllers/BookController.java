package com.fse.menurest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fse.menurest.entity.Book;
import com.fse.menurest.entity.Subject;
import com.fse.menurest.exception.BookException;
import com.fse.menurest.exception.BookNotFoundException;
import com.fse.menurest.services.BookService;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:4200")
public class BookController {
	
	@Autowired
	BookService bookService;
	

	@GetMapping("/books")
	public List<Book> getBooks(){
		List<Book> books=this.bookService.getAllBooks();
		
		if(books==null || books.isEmpty()) {
			throw new BookNotFoundException("No Book Records not Found!!!");
		}
		return books;
	}
	
	@GetMapping("/books/{bookId}")
	public Book getBook(@PathVariable Long bookId){
		Book book=this.bookService.getBookById(bookId);
		
		if(book==null) {
			throw new BookNotFoundException("Book id not found - " + bookId);
		}
		
		return book;
	}
	
	
	
	@PostMapping("/books")
	public Book addBook(@RequestBody Book book){
		
		if(!this.bookService.addBook(book)) {
			throw new BookException("Cannot add new Book!!!");
		}
		return book;
	}
	
	//going to recieve json object from client
	//converted object shall be received as argument in method
	//add PUT mapping for /api/books
	//in success : return back same book instance
	@PutMapping("/books")
	public Book editBook(@RequestBody Book book){
		Book book1= this.bookService.getBookById(book.getBookId());
		
		if(book1==null) {
			throw new BookNotFoundException("Book id not found - " + book.getBookId());
		}
		
		if(!this.bookService.update(book)) {
			throw new BookException("Cannot update Book data!!!");
		}
		return book;
	}
	
	//add DELETE mapping for /api/books/{bookId}
	//in success : return back same book instance (which is being deleted)
	@DeleteMapping("/books/{bookId}")
	public Book deleteBook(@PathVariable Long bookId){
		//check if id is valid
		Book book=this.bookService.getBookById(bookId);
		
		if(book==null) {
			throw new BookNotFoundException("Book id not found - " + bookId);
		}
		
		//check if deletion is successful
		if(!this.bookService.delete(bookId)) {
			throw new BookException("Cannot delete Book data with id - " + bookId);
		}
		
		//success
		return book;
	}
}

