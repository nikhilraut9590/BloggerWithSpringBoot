package com.nikhilraut.blogger.exception;

import java.io.Serializable;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BlogNotFoundException extends RuntimeException implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	public BlogNotFoundException() {
		// TODO Auto-generated constructor stub
	}

	public BlogNotFoundException(String message) {
		super(message);
	}
}
