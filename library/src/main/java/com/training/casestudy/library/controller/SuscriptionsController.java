package com.training.casestudy.library.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.casestudy.library.model.Subscription;
import com.training.casestudy.library.service.SubscriptionsService;

@RestController
@RequestMapping("/subscriptions")
public class SuscriptionsController {

	@Autowired
	private SubscriptionsService subscriptionsService;
	
	@GetMapping
	public List<Subscription> getAllSusbcriptions(@RequestParam(name = "subscriberName", required = false) String subscriberName) {
		return subscriptionsService.getSubscriptions(subscriberName);
	}
	
	@PostMapping
	public ResponseEntity<String> addSubscription(@Valid @RequestBody Subscription subscription) {
		subscriptionsService.addSubscription(subscription);
		return new ResponseEntity<String>("SUCCESS" , CREATED);
		
		
	} 
}
