/**
 * CONFIDENTIAL INFORMATION
 * <p>
 * All Rights Reserved.  Unauthorized reproduction, transmission, or
 * distribution of this software is a violation of applicable laws.
 * <p>
 * Date: Dec 28, 2017
 * Copyright 2017 innoirvinge@gmail.com
 */
package com.example.inno.model;

import com.example.inno.config.InnoMessages.Code;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.joda.time.DateTime;

/**
 * @author irving09 <innoirvinge@gmail.com>
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
public class InnoError {

    private String message;

    private DateTime timeStamp;

    private Code code;

    public String getTimeStamp() {
        return timeStamp.toString();
    }

}
