package com.training.casestudy.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.casestudy.library.model.Book;
import com.training.casestudy.library.service.BooksService;

@RestController
@RequestMapping("/books")
public class BooksController {

	@Autowired
	private BooksService booksService;
	
	@GetMapping
	public List<Book> getAllBooks() {
		return booksService.getAllBooks();
	}
}
