package com.nikhilraut.blogger.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.MediaTypeNotSupportedStatusException;


public class BlogControllerException {

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<Object> exception(RuntimeException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(BlogException.class)
	public ResponseEntity<Object> exception(BlogException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(MediaTypeNotSupportedStatusException.class)
	public ResponseEntity<Object> exception(MediaTypeNotSupportedStatusException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(HttpMediaTypeNotSupportedException.class)
	public ResponseEntity<Object> exception(HttpMediaTypeNotSupportedException exception) {
		return new ResponseEntity<>("Please check media type while sending data", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> exception(Exception exception) {
		return new ResponseEntity<>("Something went wrong", HttpStatus.BAD_REQUEST);
	}
}
