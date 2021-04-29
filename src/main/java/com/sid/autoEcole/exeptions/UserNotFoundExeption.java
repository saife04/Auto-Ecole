package com.sid.autoEcole.exeptions;

public class UserNotFoundExeption extends RuntimeException {
	
	
	/**
	 * Default SERIAL VERSION UID
	 */
	private static final long serialVersionUID = 1L;
	
	private final static String SINGLE_EXCEPTION_MESSAGE = "The specified user is not found";
	private final static String STUDENT_NAME_EXCEPTION_MESSAGE = "ThIS student is not found. User name : ";

	public UserNotFoundExeption() {
		super(SINGLE_EXCEPTION_MESSAGE);
	}
	
	public UserNotFoundExeption(String userName) {
		super(STUDENT_NAME_EXCEPTION_MESSAGE + userName);
	}
}
