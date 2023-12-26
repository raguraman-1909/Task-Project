package com.TaskProject.exception;

public class TaskNotFoundException extends RuntimeException {

    public TaskNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
