package com.nikhilraut.blogger.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice()
public class CustomFeedbackExceptionHandler extends ResponseEntityExceptionHandler {
	
	/*@ExceptionHandler(FeedbackNotFoundException.class)
	public final ResponseEntity<Object> handleFeedbackNotFoundException(FeedbackException exception,
			WebRequest request) {
		List<String> details = new ArrayList<>();
		details.add(exception.getError_code());
		details.add(exception.getError_message());
		ErrorResponse errorResponse = new ErrorResponse("Sorry! No Feedback found.", details);
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}*/
}
