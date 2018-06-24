/**
 * CONFIDENTIAL INFORMATION
 * <p>
 * All Rights Reserved.  Unauthorized reproduction, transmission, or
 * distribution of this software is a violation of applicable laws.
 * <p>
 * Date: Dec 28, 2017
 * Copyright 2017 innoirvinge@gmail.com
 */
package com.example.inno.exception;

import com.example.inno.config.ApiMessages;
import com.example.inno.model.ApiError;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import static com.example.inno.config.ApiMessages.Code.*;
import static com.example.inno.config.ApiMessages.Code.INTERNAL_SERVER_ERROR;

/**
 * @author irving09 <innoirvinge@gmail.com>
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @Autowired
    private ApiMessages messageSourceConfig;

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponseEntity<ApiError> handler(MethodArgumentTypeMismatchException ex) {
        String message = String.format(messageSourceConfig.get(INVALID_PATH_PARAMETERS),
                ex.getName(),
                ex.getValue());

        ApiError error = ApiError.builder()
                .message(message)
                .timeStamp(DateTime.now())
                .code(INVALID_PATH_PARAMETERS)
                .build();

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(error);
    }

    @ExceptionHandler(EntityNotFounException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ResponseEntity<ApiError> handler(EntityNotFounException ex) {
        String message = String.format(messageSourceConfig.get(ENTITY_NOT_FOUND), ex.getId());

        ApiError error = ApiError.builder()
                .message(message)
                .timeStamp(DateTime.now())
                .build();

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(error);
    }

    @ExceptionHandler(HttpClientErrorException.class)
    @ResponseBody
    public ResponseEntity<ApiError> handler(HttpClientErrorException ex) {
        String message;
        HttpStatus statusCode;
        if (ex.getStatusCode() == HttpStatus.NOT_FOUND) {
            message = messageSourceConfig.get(ENTITY_NOT_FOUND);
            statusCode = HttpStatus.NOT_FOUND;
        } else {
            message = ex.getMessage();
            statusCode = ex.getStatusCode();
        }

        ApiError error = ApiError.builder()
            .message(message)
            .timeStamp(DateTime.now())
            .code(ApiMessages.Code.RESOURCE_NOT_FOUND)
            .build();

        return ResponseEntity
                .status(statusCode)
                .body(error);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ResponseEntity<ApiError> handler(Exception ex) {

        String message = String.format(
                messageSourceConfig.get(INTERNAL_SERVER_ERROR),
                ex.getMessage());

        ApiError error = ApiError.builder()
                .message(message)
                .timeStamp(DateTime.now())
                .code(INTERNAL_SERVER_ERROR)
                .build();

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(error);
    }

}
