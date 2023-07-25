package com.ssp2.ssp2.exception;


public class FailedToRetrieveOrdersException extends RuntimeException {

    public FailedToRetrieveOrdersException() {
        super("Orders could not be retrieved.");
    }
}
