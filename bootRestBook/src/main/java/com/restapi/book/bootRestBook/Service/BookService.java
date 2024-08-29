package com.restapi.book.bootRestBook.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.restapi.book.bootRestBook.Dao.BookRepository;
import com.restapi.book.bootRestBook.Entity.Book;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
//	public Book findByName(String name) {
//		Book book =bookRepository.findByName(name);
//		return book;
//	}

	
	


	// Get all book
	public List<Book> getAllBook(Book book){
	List<Book>	book1 =(List<Book>) bookRepository.findAll();
	return book1;
		//return list;
	
	}
	
	//Get particular Book 
	public Book getBookByIsbn(long isbn) {
		Optional<Book> optional = bookRepository.findById(isbn);
		Book book = optional.get();
		return book;
	}
	//Add Book
	public Book addBook(Book book) {
		Book book1 = bookRepository.save(book);
	return book1;
	}
	// Add ALL Books
	
	public List<Book> addAll(List<Book> book){
		List<Book> book1 =(List<Book>) bookRepository.saveAll(book);
		return book1;
	}
	// To delete
	public void deleteBookByIsbn(long isbn) {
		//boolean remove = list.stream().filter(e->e.getId()==id.findFirst().r)
		
//		boolean b =list.removeIf(e->e.getId()==id);
//		if(b== true)
//			return true;
//		return false;
		bookRepository.deleteById(isbn);;
		
	}
	
	
	
	
	// To update 
	public Book updateByIsbn(Book book ,long isbn) {

		Optional<Book> existingBook = bookRepository.findById(isbn);
		
		 if (existingBook.isPresent()) {
		        Book book1 = existingBook.get();
		
		        book1.setAuthor(book.getAuthor());
		        book1.setTitle(book.getTitle());
		        book1.setPublished_date(book.getPublished_date());

		bookRepository.save(book1);

	}
		return book;
}
}
