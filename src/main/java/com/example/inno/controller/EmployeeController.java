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

import com.example.inno.model.CreateEmployeeRequest;
import com.example.inno.model.Employee;
import com.example.inno.model.UpdateEmployeeRequest;
import com.example.inno.service.CompanyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * @author irving09 <innoirvinge@gmail.com>
 */
@RestController
@RequestMapping(
        value = "/v1/company",
        produces = APPLICATION_JSON_VALUE)
public class EmployeeController {

    private final CompanyService companyService;

    public EmployeeController(final CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping(
            value = "/{companyId}/employee",
            produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List<Employee>> getAllEmployees(@PathVariable("companyId") final long companyId) {
        final List<Employee> response = companyService.getAllEmployees(companyId);
        return ResponseEntity.ok(response);
    }

    @GetMapping(
            value = "/{companyId}/employee/{employeeId}",
            produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Employee> getAllEmployees(@PathVariable("companyId") final long companyId,
                                                    @PathVariable("employeeId") final long employeeId) {
        final Employee employee = companyService.getEmployee(companyId, employeeId);
        return ResponseEntity.ok(employee);
    }

    @PostMapping(
            value = "/{companyId}/employee/",
            consumes = APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Employee> createEmployee(@PathVariable final long companyId,
                                                   @RequestBody final CreateEmployeeRequest innoRequest,
                                                   final HttpServletRequest request) throws URISyntaxException {
        // TODO make controller level validation

        final long employeeId = companyService.createEmployee(innoRequest);
        final Employee created = companyService.getEmployee(companyId, employeeId);

        UriComponents location = UriComponentsBuilder
                .fromUriString(request.getRequestURL().toString())
                .path(Long.toString(created.getId()))
                .build();

        return ResponseEntity
                .created(new URI(location.toString()))
                .body(created);
    }

    @PutMapping(
            value = "/{companyId}/employee/{employeeId}",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity updateEmployee(@PathVariable final long companyId,
                                         @PathVariable final long employeeId,
                                         @RequestBody final UpdateEmployeeRequest request) {
        // TODO make controller level validation
        companyService.updateEmployee(companyId, employeeId, request);
        final Employee response = companyService.getEmployee(companyId, employeeId);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{companyId}/employee/{employeeId}")
    @ResponseBody
    public ResponseEntity<Employee> removeEmployee(@PathVariable final long companyId,
                                                   @PathVariable final long employeeId) {
        final Employee employee = companyService.removeEmployee(companyId, employeeId);
        return ResponseEntity.ok(employee);
    }

}
