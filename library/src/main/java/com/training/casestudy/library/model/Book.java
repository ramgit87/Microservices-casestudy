package com.training.casestudy.library.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Book implements Serializable{

	private static final long serialVersionUID = 5911844650730398222L;
	
	@Id
	@Column(name = "BOOK_ID")
	private String bookId;

	@Column(name = "BOOK_NAME")
	private String name;
	
	private String author;
	
	@Column(name = "AVAILABLE_COPIES")
	private Integer copiesAvailable;
	
	@Column(name = "TOTAL_COPIES")
	private Integer totalCopies;
	
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Integer getCopiesAvailable() {
		return copiesAvailable;
	}
	public void setCopiesAvailable(Integer copiesAvailable) {
		this.copiesAvailable = copiesAvailable;
	}
	public Integer getTotalCopies() {
		return totalCopies;
	}
	public void setTotalCopies(Integer totalCopies) {
		this.totalCopies = totalCopies;
	}

	public Book decrementAvailableCopiesByOne() {
		this.setCopiesAvailable(copiesAvailable - 1);
		return this;
	}
}
