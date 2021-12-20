package com.training.casestudy.library.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.casestudy.library.model.Book;

@Repository
public interface BooksRepository extends JpaRepository<Book, Integer>{

	Optional<Book> findByBookId(String bookId);

	
}
