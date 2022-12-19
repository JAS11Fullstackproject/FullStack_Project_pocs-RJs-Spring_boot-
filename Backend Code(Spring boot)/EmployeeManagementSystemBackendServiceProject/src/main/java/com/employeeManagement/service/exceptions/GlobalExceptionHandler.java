package com.employeeManagement.service.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.modelmapper.internal.bytebuddy.asm.Advice.OffsetMapping.ForOrigin.Renderer.ForReturnTypeName;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.employeeManagement.service.payloads.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse>resourceNotFoundExceptionHandler(ResourceNotFoundException ex){
		String message=ex.getMessage();
		ApiResponse apiResponse =new ApiResponse(message,false);
	return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.NOT_FOUND);	
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>>handleMethodArgsNotValidException(MethodArgumentNotValidException ex){
		Map<String, String>resp=new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error)->{
		String fieldName=((FieldError)error).getField();
	    String defaultMessage=error.getDefaultMessage();
	    resp.put(fieldName, defaultMessage);
			
			
		});
		return new ResponseEntity<Map<String,String>>(resp,HttpStatus.BAD_REQUEST);
	}

	
	// trying these:=> in-process
	
	@ExceptionHandler(CannotCreateTransactionException.class)
	public ResponseEntity<ApiResponse>cannotCreateTransactionExceptionHandler(CannotCreateTransactionException ex){
		String message=ex.getMessage();
		ApiResponse apiResponse =new ApiResponse(message,false);
	    return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.SERVICE_UNAVAILABLE);

	}
	
	@ExceptionHandler(TransactionSystemException.class)
	public ResponseEntity<ApiResponse>transactionSystemExceptionHandler(TransactionSystemException ex){
		String message=ex.getMessage();
		ApiResponse apiResponse =new ApiResponse(message,false);
	return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.SERVICE_UNAVAILABLE);	

	}
	
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public ResponseEntity<ApiResponse>httpRequestMethodNotSupportedExceptionHandler(HttpRequestMethodNotSupportedException ex){
		String message=ex.getMessage();
		ApiResponse apiResponse =new ApiResponse(message,false);
	return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.NOT_FOUND);	

	}
	
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<ApiResponse>methodArgumentTypeMismatchExceptionHandler(MethodArgumentTypeMismatchException ex,WebRequest request){
		String message=ex.getMessage();
		ApiResponse apiResponse =new ApiResponse(message,false);
	return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.NOT_FOUND);
	
	
	// trying these:=> in-process
		

	}

}
