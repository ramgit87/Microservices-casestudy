package com.training.casestudy.library.controller;

import org.springframework.http.HttpStatus;import org.springframework.web.bind.annotation.ControllerAdvice;import org.springframework.web.bind.annotation.ExceptionHandler;import org.springframework.web.bind.annotation.ResponseBody;import org.springframework.web.bind.annotation.ResponseStatus;import com.training.casestudy.library.error.CopyNotAvailableException;

@ControllerAdvice(assignableTypes = SuscriptionsController.class)public class CcsClientRestExceptionAdvisor {	@ExceptionHandler(CopyNotAvailableException.class)	@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)	@ResponseBody	public String handleException(CopyNotAvailableException e) {		return e.getMessage();	}}
