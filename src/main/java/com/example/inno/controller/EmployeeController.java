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
import com.example.inno.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.servlet.http.HttpServletRequest;
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

    private final EmployeeService employeeService;

    public EmployeeController(final EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(
            value = "/{companyId}/employee",
            produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List<Employee>> getAllEmployees(@PathVariable("companyId") final long companyId) {
//        final List<Employee> response = employeeService.getAllEmployees(companyId);
//        return ResponseEntity.ok(response);
        throw new NotImplementedException();
    }

    @GetMapping(
            value = "/{companyId}/employee/{employeeId}",
            produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Employee> getAllEmployees(@PathVariable("companyId") final long companyId,
                                                    @PathVariable("employeeId") final long employeeId) {
        throw new NotImplementedException();
//        final Employee employee = employeeService.getEmployee(employeeId);
//        return ResponseEntity.ok(employee);
    }

    @PostMapping(
            value = "/{companyId}/employee/",
            consumes = APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Employee> createEmployee(@PathVariable final long companyId,
                                                   @RequestBody final CreateEmployeeRequest innoRequest,
                                                   final HttpServletRequest request) throws URISyntaxException {
        throw new NotImplementedException();
//        final long employeeId = employeeService.createEmployee(innoRequest);
//        final Employee created = employeeService.getEmployee(employeeId);
//
//        UriComponents location = UriComponentsBuilder
//                .fromUriString(request.getRequestURL().toString())
//                .path(Long.toString(created.getId()))
//                .build();
//
//        return ResponseEntity
//                .created(new URI(location.toString()))
//                .body(created);
    }

    @PutMapping(
            value = "/{companyId}/employee/{employeeId}",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity updateEmployee(@PathVariable final long companyId,
                                         @PathVariable final long employeeId,
                                         @RequestBody final UpdateEmployeeRequest request) {
//        companyService.updateEmployee(companyId, employeeId, request);
//        final Employee response = companyService.getEmployee(companyId, employeeId);
//        return ResponseEntity.ok(response);
        throw new NotImplementedException();
    }

    @DeleteMapping("/{companyId}/employee/{employeeId}")
    @ResponseBody
    public ResponseEntity<Employee> removeEmployee(@PathVariable final long companyId,
                                                   @PathVariable final long employeeId) {
//        final Employee employee = companyService.removeEmployee(companyId, employeeId);
//        return ResponseEntity.ok(employee);
        throw new NotImplementedException();
    }

}
