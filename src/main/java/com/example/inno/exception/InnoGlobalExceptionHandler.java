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

import com.example.inno.config.InnoMessages;
import com.example.inno.model.InnoError;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import static com.example.inno.config.InnoMessages.Code.INTERNAL_SERVER_ERROR;

/**
 * @author irving09 <innoirvinge@gmail.com>
 */
@ControllerAdvice
public class InnoGlobalExceptionHandler {

    @Autowired
    private InnoMessages messageSourceConfig;

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ResponseEntity<InnoError> handler(final Exception ex) {

        final String message = String.format(
                messageSourceConfig.get(INTERNAL_SERVER_ERROR),
                ex.getMessage());

        InnoError errorResponse = InnoError.builder()
                .message(message)
                .timeStamp(DateTime.now())
                .code(INTERNAL_SERVER_ERROR)
                .build();

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(errorResponse);
    }

}
