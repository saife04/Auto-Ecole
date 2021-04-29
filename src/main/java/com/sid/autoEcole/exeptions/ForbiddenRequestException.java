package com.sid.autoEcole.exeptions;

public class ForbiddenRequestException extends RuntimeException {

    /**
     * Default SERIAL VERSION UID
     */
    private static final long serialVersionUID = 1L;

    private final static String EXCEPTION_MESSAGE = "Forbidden";

    public ForbiddenRequestException() {
        super(EXCEPTION_MESSAGE);
    }
}
