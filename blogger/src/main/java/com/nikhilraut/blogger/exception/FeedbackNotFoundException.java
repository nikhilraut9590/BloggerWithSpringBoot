package com.nikhilraut.blogger.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Feedback not found")
public class FeedbackNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String error_code;
	private String error_message;

	public String getError_code() {
		return error_code;
	}

	public void setError_code(String error_code) {
		this.error_code = error_code;
	}

	public String getError_message() {
		return error_message;
	}

	public void setError_message(String error_message) {
		this.error_message = error_message;
	}

	public FeedbackNotFoundException() {
		// TODO Auto-generated constructor stub
	}

	public FeedbackNotFoundException(String error_code, String error_message) {
		super(error_message);
	}
}
