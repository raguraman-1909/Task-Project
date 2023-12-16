package com.TaskProject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TaskManagerExceptionHandler {

    @ExceptionHandler(value = {TaskManagerNotFoundException.class})
    public ResponseEntity<Object> handleTaskManagerNotFoundException
            (TaskManagerNotFoundException taskManagerNotFoundException)
    {
        TaskManagerException taskManagerException=new TaskManagerException(
                taskManagerNotFoundException.getMessage(),
                taskManagerNotFoundException.getCause(),
                HttpStatus.NOT_FOUND
        );
    return new ResponseEntity<>(taskManagerException, HttpStatus.NOT_FOUND);
    }
}
