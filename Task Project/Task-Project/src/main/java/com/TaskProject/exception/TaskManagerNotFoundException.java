package com.TaskProject.exception;

public class TaskManagerNotFoundException extends RuntimeException {
    public TaskManagerNotFoundException(String message) {
        super(message);
    }

    public TaskManagerNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
