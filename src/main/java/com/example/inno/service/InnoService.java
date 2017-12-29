/**
 * CONFIDENTIAL INFORMATION
 * <p>
 * All Rights Reserved.  Unauthorized reproduction, transmission, or
 * distribution of this software is a violation of applicable laws.
 * <p>
 * Date: Dec 28, 2017
 * Copyright 2017 innoirvinge@gmail.com
 */
package com.example.inno.service;

import com.example.inno.model.Company;
import com.example.inno.model.Inno;
import com.example.inno.model.InnoRequest;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author irving09 <innoirvinge@gmail.com>
 */
@Service
public class InnoService {

    public Inno get(final long id) {
        // TODO make call to db here using id
        return Inno.builder()
                .id(id)
                .firstName("inno")
                .lastName("estrera")
                .company(Company.builder()
                        .id(ThreadLocalRandom.current().nextLong(1, Long.MAX_VALUE))
                        .name("CDK Global")
                        .address("605 5th Ave S #800, Seattle, WA 98104")
                        .build())
                .build();
    }

    public long create(InnoRequest request) {
        // TODO make call to db here using id
        return ThreadLocalRandom.current().nextLong(1, Long.MAX_VALUE);
    }
}
