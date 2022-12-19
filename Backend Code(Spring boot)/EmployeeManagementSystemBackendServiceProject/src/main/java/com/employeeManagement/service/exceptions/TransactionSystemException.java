package com.employeeManagement.service.exceptions;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class TransactionSystemException extends RuntimeException{
	
	
	String resourceName;
	String fieldName;
	long fieldValue;
	public TransactionSystemException(String resourceName, String fieldName, long fieldValue) {
		super(String.format("%s not found with %s : %s", resourceName,fieldName,fieldValue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
}
