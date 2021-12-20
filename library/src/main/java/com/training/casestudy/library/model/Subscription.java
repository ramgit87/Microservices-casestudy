package com.training.casestudy.library.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Subscription implements Serializable{

	private static final long serialVersionUID = 3341067886439218785L;
	
	@Id
	private String subscriberName;
	private LocalDate dateSubscribed;
	private LocalDate dateReturned;
	
	@NotBlank(message = "Book Id is required for creating a subscription")
	private String bookId;
	
	public String getSubscriberName() {
		return subscriberName;
	}
	public void setSubscriberName(String subscriberName) {
		this.subscriberName = subscriberName;
	}
	public LocalDate getDateSubscribed() {
		return dateSubscribed;
	}
	public void setDateSubscribed(LocalDate dateSubscribed) {
		this.dateSubscribed = dateSubscribed;
	}
	public LocalDate getDateReturned() {
		return dateReturned;
	}
	public void setDateReturned(LocalDate dateReturned) {
		this.dateReturned = dateReturned;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
}
