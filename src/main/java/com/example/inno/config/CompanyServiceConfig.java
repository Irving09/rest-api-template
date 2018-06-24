/**
 * CONFIDENTIAL INFORMATION
 * <p>
 * All Rights Reserved.  Unauthorized reproduction, transmission, or
 * distribution of this software is a violation of applicable laws.
 * <p>
 * Date: Jun 24, 2018
 * Copyright 2018 innoirvinge@gmail.com
 */
package com.example.inno.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author irving09 <innoirvinge@gmail.com>
 */
@Getter
@Configuration
@PropertySource("classpath:application.properties")
public class CompanyServiceConfig {

    @Value("${company.service.host}")
    private String companyServiceHost;

    @Value("${employee.service.host}")
    private String employeeServiceHost;

}
