package com.TaskProject.exception;

import org.springframework.http.HttpStatus;

public record TaskManagerException(String message, Throwable throwable, HttpStatus httpStatus) {
}
