package com.nikhilraut.blogger.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException.UnsupportedMediaType;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomExceptionControllerAdviceHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(BlogNotFoundException.class)
	public final ResponseEntity<Object> handleBlogNotFoundException(BlogNotFoundException bnfe, WebRequest request) {
		List<String> details = new ArrayList<>();
		details.add("blog is not availble in database.");
		ErrorResponse error = new ErrorResponse("Blog Not Found.", details);
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception exception, WebRequest request) {
		List<String> details = new ArrayList<>();
		details.add("may be data not available in database.");
		ErrorResponse errorResponse = new ErrorResponse("Something went wrong", details);
		return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(UnsupportedMediaType.class)
	public final ResponseEntity<Object> handleUnsupportedFormatException(UnsupportedMediaType exception,
			WebRequest request) {
		List<String> details = new ArrayList<>();
		details.add(exception.getLocalizedMessage());
		ErrorResponse errorResponse = new ErrorResponse("Mediatype is not supported. Make sure it is in JSON format.",
				details);
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(FeedbackNotFoundException.class)
	public final ResponseEntity<Object> handleFeedbackNotFoundException(FeedbackNotFoundException exception,
			WebRequest request) {
		List<String> details = new ArrayList<>();
		ErrorResponse errorResponse = new ErrorResponse("Sorry! No Feedback found.", details);
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}
}


