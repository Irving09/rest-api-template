/**
 * CONFIDENTIAL INFORMATION
 * <p>
 * All Rights Reserved.  Unauthorized reproduction, transmission, or
 * distribution of this software is a violation of applicable laws.
 * <p>
 * Date: Dec 29, 2017
 * Copyright 2017 innoirvinge@gmail.com
 */
package com.example.inno.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * @author irving09 <innoirvinge@gmail.com>
 */
@Component
public class RestApiHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {

        // TODO perform specific health check here

        return Health.up().build();
    }

}