package com.andreitop.newco.dtoApiError;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class GlobalControllerExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = NoEntityException.class)
    protected ResponseEntity<Object> handleConflictNoEntity(NoEntityException e) {
        String error = "No such entity found";
        ApiError errorBody = new ApiError(HttpStatus.NOT_FOUND, e.getMessage(), error);
        return new ResponseEntity<>(errorBody, new HttpHeaders(), errorBody.getStatus());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = Exception.class)
    protected ResponseEntity<Object> handleAllConflicts(Exception e) {
        String error = "An unexpected exception happened";
        ApiError errorBody = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), error);
        return new ResponseEntity<>(errorBody, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
    protected ResponseEntity<Object> handleMismatchConflict(MethodArgumentTypeMismatchException e) {
        String error = e.getName() + "has a wrong type";
        ApiError errorBody = new ApiError(HttpStatus.BAD_REQUEST, e.getMessage(), error);
        return new ResponseEntity<>(errorBody, errorBody.getStatus());
    }
}
