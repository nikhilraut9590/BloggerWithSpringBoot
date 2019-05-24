package com.nikhilraut.blogger.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class FeedbackControllerException extends ResponseEntityExceptionHandler{

	@ExceptionHandler(FeedbackNotFoundException.class)
	public final ResponseEntity<String> handleFeedbackNotFoundException(FeedbackNotFoundException exception,
			WebRequest request) {
		return new ResponseEntity<String>("sorry! Feedback not available.", HttpStatus.NOT_FOUND);
	}
}
