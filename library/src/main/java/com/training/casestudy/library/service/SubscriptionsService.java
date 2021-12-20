package com.training.casestudy.library.service;

import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.casestudy.library.error.CopyNotAvailableException;
import com.training.casestudy.library.model.Subscription;
import com.training.casestudy.library.repository.BooksRepository;
import com.training.casestudy.library.repository.SubscriptionsRepository;

@Service
public class SubscriptionsService{

	@Autowired
	private SubscriptionsRepository subscriptionsRepo;
	
	@Autowired
	private BooksRepository booksRepo;
	
	public List<Subscription> getSubscriptions(String subscriberName) {
		return StringUtils.isNotBlank(subscriberName) ? 
				subscriptionsRepo.findBySubscriberName(subscriberName) : subscriptionsRepo.findAll();
	}
	
	public Subscription addSubscription(Subscription subscription) {
		return  booksRepo.findByBookId(subscription.getBookId())
				.filter(book -> book.getCopiesAvailable() > 0).map(book -> booksRepo.save(book.decrementAvailableCopiesByOne()))
				.map(k -> Optional.of(subscriptionsRepo.save(subscription)).get()).orElseThrow(() -> new CopyNotAvailableException());
					 
	}
}
