package com.nikhilraut.blogger.exception;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name="error")
public class ErrorResponse {
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getDetails() {
		return details;
	}

	public void setDetails(List<String> details) {
		this.details = details;
	}

	private List<String> details;

	public ErrorResponse(String message, List<String> details) {
		super();
		this.message = message;
		this.details = details;
	}
	public ErrorResponse() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ErrorResponse [message=" + message + ", details=" + details + "]";
	}
	
}
