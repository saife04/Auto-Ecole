package com.sid.autoEcole.exeptions;

public class BadRequestException extends RuntimeException {

	/**
	 * Default SERIAL VERSION UID
	 */
	private static final long serialVersionUID = 1L;

	private final static String EXCEPTION_MESSAGE = "Bad request";

	public BadRequestException() {
		super(EXCEPTION_MESSAGE);
	}
	public BadRequestException(ExceptionType exceptionType) {
		super(exceptionType.name());
	}
}
