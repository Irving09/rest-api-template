/**
 * CONFIDENTIAL INFORMATION
 * <p>
 * All Rights Reserved.  Unauthorized reproduction, transmission, or
 * distribution of this software is a violation of applicable laws.
 * <p>
 * Date: Dec 28, 2017
 * Copyright 2017 innoirvinge@gmail.com
 */
package com.example.inno.config;

import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.context.support.MessageSourceAccessor;

/**
 * @author irving09 <innoirvinge@gmail.com>
 */

@Builder
@AllArgsConstructor
public class ApiMessages {

    private MessageSourceAccessor accessor;

    public String get(final Code code) {
        return accessor.getMessage(code.toString());
    }

    public enum Code {
        INTERNAL_SERVER_ERROR,
        INVALID_PATH_PARAMETERS,
        ENTITY_NOT_FOUND,
        RESOURCE_NOT_FOUND
    }
}
