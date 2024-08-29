package com.restapi.book.bootRestBook.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.book.bootRestBook.Entity.Book;
import com.restapi.book.bootRestBook.Service.BookService;

@RestController
//@Controller
public class BookController {
	
	@Autowired
	private BookService bookservice;

	
	@GetMapping("/getBook")
	public ResponseEntity<List<Book>> getBooK(Book book) {
		List<Book> book1 =bookservice.getAllBook(book);
		if(book1.size()<=0)
		{	
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();}
		
		return ResponseEntity.of(Optional.of(book1));
	}
	

	
	@GetMapping("/getBookByIsbn/{id}")
	public ResponseEntity<Book> getBookByIsbn(@PathVariable("isbn")long isbn) {
		Book book=bookservice.getBookByIsbn(isbn);
		if(book==null)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(book));
	}
	
	@PostMapping("/addBook")
	public Book addBook(@RequestBody Book book) {
		Book b =bookservice.addBook(book);
		return b;
	}
	
	// =======To add all book ==========
	
	@PostMapping("/addallbook")
	public List<Book> addAllBook(@RequestBody List<Book> books){
		List<Book> book = bookservice.addAll(books);
		return book;
	}
	

	@DeleteMapping("/Deletebyisbn/{isbn}")
	public ResponseEntity<Book> deleteByIsbn(@PathVariable("isbn") long isbn){
		try {
				bookservice.deleteBookByIsbn(isbn);
			
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}		
	}
	

	@PutMapping("/updateByIsbn/{isbn}")
	public ResponseEntity<Book> updateBookByIsbn(@RequestBody Book book ,@PathVariable("isbn") long isbn1) {
		try {
			bookservice.updateByIsbn(book, isbn1);
			return ResponseEntity.status(HttpStatus.OK).body(book);
		} catch (Exception e) {
			e.printStackTrace();
			
			
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	
	}
	
}
