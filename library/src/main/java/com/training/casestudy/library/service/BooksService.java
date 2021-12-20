package com.training.casestudy.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.training.casestudy.library.model.Book;
import com.training.casestudy.library.repository.BooksRepository;

@Service
public class BooksService{

	@Autowired
	private BooksRepository booksRepo;
	
	@GetMapping
	public List<Book> getAllBooks() {
		return booksRepo.findAll();
	}
}
