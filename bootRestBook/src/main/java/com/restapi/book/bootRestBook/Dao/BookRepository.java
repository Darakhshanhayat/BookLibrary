package com.restapi.book.bootRestBook.Dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.restapi.book.bootRestBook.Entity.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

}
