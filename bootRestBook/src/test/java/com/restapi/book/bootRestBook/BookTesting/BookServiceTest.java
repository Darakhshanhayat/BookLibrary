package com.restapi.book.bootRestBook.BookTesting;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;


import com.restapi.book.bootRestBook.Dao.BookRepository;
import com.restapi.book.bootRestBook.Entity.Book;
import com.restapi.book.bootRestBook.Service.BookService;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {
	
	 @InjectMocks
	    private BookService bookService;

	    @Mock
	    private BookRepository bookRepository;

	    Book book;
	    @BeforeEach
	    void setUp() {
	        MockitoAnnotations.openMocks(this);
	    }
	    
	    @Test
	    void testAddBook() {
	        Book book = new Book(1L, "Novel",LocalDate.parse("2000-09-07") , "xyz");
	        when(bookRepository.save(book)).thenReturn(book);

	        Book result = bookService.addBook(book);

	        assertEquals("Novel", result.getTitle());
	        assertEquals("xyz", result.getAuthor());
	        assertEquals("2000-09-07", result.getPublished_date());
	        
	    }
	    
	    
	    @Test
	    void testGetAllBooks() {
	        Book book1 = new Book(1L, "Novel",LocalDate.parse("2000-09-07") , "xyz");
	        Book book2 = new Book(2L, "comedy", LocalDate.parse("2000-09-07"), "lmn");
	        List<Book> books = Arrays.asList(book1, book2);

	        when(bookRepository.findAll()).thenReturn(books);

	        List<Book> result = bookService.getAllBook(book);

	        assertEquals(2, result.size());
	       
	    }
	    
	    @Test
	    void testDeleteBookByIsbn() {
	        doNothing().when(bookRepository).deleteById(1L);

	        bookService.deleteBookByIsbn(1L);

	        
	    }
	    @Test
	    void testUpdateByIsbn() {
	        Book existingBook = new Book(1L, "Novel",LocalDate.parse("2000-09-07"), "xyz");
	        Book updatedBook = new Book(1L, "Comedy",LocalDate.parse("2000-09-07") , "lmn");

	        when(bookRepository.findById(1L)).thenReturn(Optional.of(existingBook));
	        when(bookRepository.save(existingBook)).thenReturn(existingBook);

	        // Update fields
	        existingBook.setTitle(updatedBook.getTitle());
	        existingBook.setAuthor(updatedBook.getAuthor());

	        Book result = bookService.updateByIsbn(updatedBook, 1L);

	        assertEquals("Comedy", result.getTitle());
	        assertEquals("lmn", result.getAuthor());
	        
	    }

}
