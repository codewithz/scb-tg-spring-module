package com.sc.pioneers.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;

@ControllerAdvice
public class APIExceptionHandler
{
	@ExceptionHandler(value= {ResponseStatusException.class})
	public ResponseEntity<Object> handleAPIException(ResponseStatusException e,WebRequest request)
	{
		String path=request.getDescription(false).replace("uri=","");
		
		//1. Create a Payload with Exception Details 
			APIExceptionPayload payload=new APIExceptionPayload(e.getMessage(),
																e.getStatus().value(), //-404 |500
																String.valueOf(e.getStatus()), //--404 Not Found
																false,
																true,
																LocalDateTime.now(),
																path);
		
		//2. Return the response entity
			
			return new ResponseEntity<Object>(payload, e.getStatus());
			
	}

}
