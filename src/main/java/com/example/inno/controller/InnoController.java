/**
 * CONFIDENTIAL INFORMATION
 * <p>
 * All Rights Reserved.  Unauthorized reproduction, transmission, or
 * distribution of this software is a violation of applicable laws.
 * <p>
 * Date: Dec 28, 2017
 * Copyright 2017 innoirvinge@gmail.com
 */
package com.example.inno.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author irving09 <innoirvinge@gmail.com>
 */
@RestController("v1/inno")
public class InnoController {

    @GetMapping
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("{ message: \"hello world\"}");
    }

}
