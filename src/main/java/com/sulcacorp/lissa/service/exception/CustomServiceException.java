package com.sulcacorp.lissa.service.exception;

public class CustomServiceException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CustomServiceException() {
		// TODO Auto-generated constructor stub
	}

	public CustomServiceException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public CustomServiceException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public CustomServiceException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public CustomServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
