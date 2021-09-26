package com.hotel.api.exceptions;

public class HotelNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HotelNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public HotelNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
}
