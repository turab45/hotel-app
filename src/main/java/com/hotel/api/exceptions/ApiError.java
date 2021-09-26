package com.hotel.api.exceptions;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.HttpStatus;

public class ApiError {
	private String message;
	private List<String> details;
	private HttpStatus status;
	LocalDate timestamp;
	public ApiError(String message, List<String> details, HttpStatus status, LocalDate timestamp) {
		super();
		this.message = message;
		this.details = details;
		this.status = status;
		this.timestamp = timestamp;
	}
	public ApiError() {
		super();
	}
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
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	public LocalDate getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDate timestamp) {
		this.timestamp = timestamp;
	}
	
	
}
