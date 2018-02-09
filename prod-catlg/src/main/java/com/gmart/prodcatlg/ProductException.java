package com.gmart.prodcatlg;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestControllerAdvice
public class ProductException extends ResponseEntityExceptionHandler {
	
	/*@ExceptionHandler(value = {JsonMappingException.class})
	private ResponseEntity<Object> handleBadRequest(RuntimeException ex, WebRequest request) {
		System.out.println("exception handler reached");
		String bodyOfResponse = "Please provide valid input";
		return handleExceptionInternal(ex, new ResponseErrorJson(bodyOfResponse), 
		          new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}*/
	@Override
	protected
	ResponseEntity<Object> handleHttpMessageNotReadable(final HttpMessageNotReadableException ex, final HttpHeaders headers, final HttpStatus status, final WebRequest request) {
		System.out.println("exception handler reached");
		String bodyOfResponse = "{\"message\":\"Please provide valid input\"}";
		return handleExceptionInternal(ex, bodyOfResponse, 
		          headers, HttpStatus.BAD_REQUEST, request);
	}
	
	class ResponseErrorJson {
		String status;
		String message;
		ResponseErrorJson(){}
		ResponseErrorJson(String message){
			this.message = message;
		}
	}
	
}
