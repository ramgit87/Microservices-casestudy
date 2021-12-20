package com.training.casestudy.library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.casestudy.library.model.Subscription;

@Repository
public interface SubscriptionsRepository extends JpaRepository<Subscription, Integer>{

	List<Subscription> findBySubscriberName(String subscriberName);
}
