package com.sid.autoEcole.exeptions;

public class InternalServerException extends RuntimeException {

    /**
     * Default SERIAL VERSION UID
     */
    private static final long serialVersionUID = 1L;

    private final static String EXCEPTION_MESSAGE = "Internal Server";

    public InternalServerException() {
        super(EXCEPTION_MESSAGE);
    }

}
