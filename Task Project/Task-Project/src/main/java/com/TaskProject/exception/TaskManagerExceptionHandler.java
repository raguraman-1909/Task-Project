package com.TaskProject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TaskManagerExceptionHandler {

    @ExceptionHandler(value = {TaskNotFoundException.class})
    public ResponseEntity<Object> handleTaskManagerNotFoundException
            (TaskNotFoundException notFound)
    {
        TaskManagerException taskManagerException=new TaskManagerException(
                notFound.getMessage(),
                notFound.getCause(),
                HttpStatus.NOT_FOUND
        );
    return new ResponseEntity<>(taskManagerException, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UnauthorizedTaskAccessException.class)
    public ResponseEntity<String> handleUnauthorizedTaskAccessException(UnauthorizedTaskAccessException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> handleUserNotFound(UserNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
