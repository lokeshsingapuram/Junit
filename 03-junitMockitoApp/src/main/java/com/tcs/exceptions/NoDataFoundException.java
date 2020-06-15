package com.tcs.exceptions;

public class NoDataFoundException extends RuntimeException{
	
	public NoDataFoundException() {
		super();
	}
	public NoDataFoundException(String msg) {
		super(msg);
	}
}
