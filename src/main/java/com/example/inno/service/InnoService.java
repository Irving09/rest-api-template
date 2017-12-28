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
import org.springframework.stereotype.Service;

/**
 * @author irving09 <innoirvinge@gmail.com>
 */
@Service
public class InnoService {

    public Inno gettInno() {
        // TODO make call to db here
        return Inno.builder()
                .firstName("inno")
                .lastName("estrera")
                .company(Company.builder()
                        .name("CDK Global")
                        .address("605 5th Ave S #800, Seattle, WA 98104")
                        .build())
                .build();
    }

}
