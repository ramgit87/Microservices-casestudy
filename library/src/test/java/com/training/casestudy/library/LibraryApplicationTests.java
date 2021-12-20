package com.training.casestudy.library;

import static org.assertj.core.api.Assertions.assertThat;
import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import com.training.casestudy.library.error.CopyNotAvailableException;
import com.training.casestudy.library.model.Subscription;
import com.training.casestudy.library.service.BooksService;
import com.training.casestudy.library.service.SubscriptionsService;

@SpringBootTest
@AutoConfigureMockMvc
class LibraryApplicationTests {

	@Autowired
	private SubscriptionsService subscriptions;
	
	@Autowired
	private BooksService books;
	
	@Test
	public void shouldFindAllBooks() {
		assertThat(this.books.getAllBooks().size()).isEqualTo(3);
	}
	
	@Test
	public void shouldAddSubscription() {
		
		assertThat(addSubscription("BK2", "Vijay")).isNotNull();
		assertThat(this.books.getAllBooks().stream()
				.filter(b -> b.getBookId().equals("BK2"))
				.map(b -> b.getCopiesAvailable()).findFirst().get()).isEqualTo(3);
	}

	@Test
	public void shouldFindSubcripionsBySubscriberName() {
		addSubscription("BK1", "Kali");
		
		List<Subscription> matchingSubs = this.subscriptions.getSubscriptions("Kali");
		assertThat(matchingSubs.size()).isEqualTo(1);
		assertThat(matchingSubs.get(0).getBookId()).isEqualTo("BK1");
	}
	
	@Test
	public void shouldFailWhenBookIsNotAvailable() {
		addSubscription("BK3", "Tat");
		addSubscription("BK3", "Amm");
		addSubscription("BK3", "Nik");
		
		Assertions.assertThrows(CopyNotAvailableException.class, () -> addSubscription("BK3", "Mic"));

	}
	
	private Subscription addSubscription(String bookId, String subscriberName) {
		Subscription subscription = new Subscription();
		subscription.setBookId(bookId);
		subscription.setSubscriberName(subscriberName);
		subscription.setDateSubscribed(LocalDate.now());

		Subscription addedSubscription = subscriptions.addSubscription(subscription);
		return addedSubscription;
	}
}
