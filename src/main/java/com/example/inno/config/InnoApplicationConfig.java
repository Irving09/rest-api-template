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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.MessageSourceAccessor;

import java.util.Locale;

/**
 * @author irving09 <innoirvinge@gmail.com>
 */
@Configuration
public class InnoApplicationConfig {

    @Autowired
    private MessageSource messageSource;

    @Bean
    public InnoMessages messageSourceAccessor() {
        return InnoMessages.builder()
                .accessor(new MessageSourceAccessor(messageSource, Locale.ENGLISH))
                .build();
    }

}
