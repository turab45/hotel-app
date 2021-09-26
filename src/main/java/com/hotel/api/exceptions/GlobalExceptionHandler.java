package com.hotel.api.exceptions;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{

	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<String> details = new ArrayList<>();
		details.add("Method not supported");
		
		ApiError error = new ApiError(ex.getMessage(), details, status, LocalDate.now());
		
		return ResponseEntity.status(status).body(error);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<String> details = new ArrayList<>();
		details.add("Media not supported. Please provide data in JSON format.");
		
		ApiError error = new ApiError(ex.getMessage(), details, status, LocalDate.now());
		
		return ResponseEntity.status(status).body(error);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotAcceptable(HttpMediaTypeNotAcceptableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<String> details = new ArrayList<>();
		details.add("Media type not acceptable. JSON type media is acceptable.");
		
		ApiError error = new ApiError(ex.getMessage(), details, status, LocalDate.now());
		
		return ResponseEntity.status(status).body(error);
	}

	@Override
	protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		List<String> details = new ArrayList<>();
		details.add("Path variable is missing.");
		details.add(ex.getMessage());
		
		ApiError error = new ApiError(ex.getMessage(), details, status, LocalDate.now());
		
		return ResponseEntity.status(status).body(error);
	}

	@Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<String> details = new ArrayList<>();
		details.add("Request parameter is missing.");
		
		ApiError error = new ApiError(ex.getMessage(), details, status, LocalDate.now());
		
		return ResponseEntity.status(status).body(error);
	}

	@Override
	protected ResponseEntity<Object> handleServletRequestBindingException(ServletRequestBindingException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<String> details = new ArrayList<>();
		details.add("Data binding exception");
		
		ApiError error = new ApiError(ex.getMessage(), details, status, LocalDate.now());
		
		return ResponseEntity.status(status).body(error);
	}

	@Override
	protected ResponseEntity<Object> handleConversionNotSupported(ConversionNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		return super.handleConversionNotSupported(ex, headers, status, request);
	}

	@Override
	protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		List<String> details = new ArrayList<>();
		details.add("Type mismatched.");
		
		ApiError error = new ApiError(ex.getMessage(), details, status, LocalDate.now());
		
		return ResponseEntity.status(status).body(error);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<String> details = new ArrayList<>();
		details.add("Http message is not readable.");
		
		ApiError error = new ApiError(ex.getMessage(), details, status, LocalDate.now());
		
		return ResponseEntity.status(status).body(error);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotWritable(HttpMessageNotWritableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		return super.handleHttpMessageNotWritable(ex, headers, status, request);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		return super.handleMethodArgumentNotValid(ex, headers, status, request);
	}

	@Override
	protected ResponseEntity<Object> handleMissingServletRequestPart(MissingServletRequestPartException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		return super.handleMissingServletRequestPart(ex, headers, status, request);
	}

	@Override
	protected ResponseEntity<Object> handleBindException(BindException ex, HttpHeaders headers, HttpStatus status,
			WebRequest request) {
		// TODO Auto-generated method stub
		return super.handleBindException(ex, headers, status, request);
	}

	@Override
	protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		return super.handleNoHandlerFoundException(ex, headers, status, request);
	}

	@Override
	protected ResponseEntity<Object> handleAsyncRequestTimeoutException(AsyncRequestTimeoutException ex,
			HttpHeaders headers, HttpStatus status, WebRequest webRequest) {
		// TODO Auto-generated method stub
		return super.handleAsyncRequestTimeoutException(ex, headers, status, webRequest);
	}

	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		return super.handleExceptionInternal(ex, body, headers, status, request);
	}
	
	@ExceptionHandler(HotelNotFoundException.class)
	protected ResponseEntity<Object> handleHotelNotFound(HotelNotFoundException ex) {
		List<String> details = new ArrayList<>();
		details.add("Hotel not found.");
		details.add(ex.getMessage());
		
		ApiError error = new ApiError(ex.getMessage(), details, HttpStatus.BAD_REQUEST, LocalDate.now());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}

	
	@ExceptionHandler(IdNotFoundException.class)
	protected ResponseEntity<Object> handleIdNotFound(IdNotFoundException ex) {
		List<String> details = new ArrayList<>();
		details.add("Hotel with this id id not found.");
		details.add(ex.getMessage());
		
		ApiError error = new ApiError(ex.getMessage(), details, HttpStatus.NOT_FOUND, LocalDate.now());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	
	
	@ExceptionHandler(Exception.class)
	protected ResponseEntity<Object> handleAll(Exception ex) {
		List<String> details = new ArrayList<>();
		details.add("Something went wrong.");
		details.add(ex.getMessage());
		
		ApiError error = new ApiError(ex.getMessage(), details, HttpStatus.NOT_FOUND, LocalDate.now());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	
	
}
