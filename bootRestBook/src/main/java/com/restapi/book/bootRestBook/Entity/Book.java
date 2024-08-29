package com.restapi.book.bootRestBook.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;
@Setter
@Getter
@AllArgsConstructor
@Entity
@Table(name="Books")
@Builder
public class Book {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long isbn;
	private String title;
	private LocalDate published_date;
	
	private String author;
	
	
	public Book() {
		super();
	}

	


	
	

}
