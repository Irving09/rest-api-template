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

import com.example.inno.model.Inno;
import com.example.inno.service.InnoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * @author irving09 <innoirvinge@gmail.com>
 */
@RestController
@RequestMapping("/v1/inno")
public class InnoController {

    private final InnoService service;

    public InnoController(final InnoService service) {
        this.service = service;
    }

    @GetMapping(
        value = "/test1",
        produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Inno> test() {
        final Inno response = service.gettInno();
        return ResponseEntity.ok(response);
    }

    @GetMapping(
        value = "/test2",
        produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<String> test2() {
        return ResponseEntity.ok("{ message: \"hello world 2\"}");
    }

}
