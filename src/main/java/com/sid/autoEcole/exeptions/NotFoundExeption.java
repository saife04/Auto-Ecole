package com.sid.autoEcole.exeptions;

public class NotFoundExeption extends RuntimeException {


    /**
     * Default SERIAL VERSION UID
     */
    private static final long serialVersionUID = 1L;

    private final static String SINGLE_EXCEPTION_MESSAGE = "The specified object is not found";
    private final static String STUDENT_ALREADY_EXISTS = "ThIS object is not found. Student name : ";

    public NotFoundExeption() {
        super(SINGLE_EXCEPTION_MESSAGE);
    }

    public NotFoundExeption(String message) {
        super(STUDENT_ALREADY_EXISTS + message);
    }

    public NotFoundExeption(ExceptionType exceptionType) {
        super(exceptionType.name());
    }
}
