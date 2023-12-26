package com.TaskProject.exception;


public class UnauthorizedTaskAccessException extends RuntimeException {

    public UnauthorizedTaskAccessException(String message, Throwable cause) {
        super(message, cause);
    }
}
