/**
 * CONFIDENTIAL INFORMATION
 * <p>
 * All Rights Reserved.  Unauthorized reproduction, transmission, or
 * distribution of this software is a violation of applicable laws.
 * <p>
 * Date: Dec 29, 2017
 * Copyright 2017 innoirvinge@gmail.com
 */
package com.example.inno.controller;

import com.example.inno.model.Company;
import com.example.inno.model.CreateCompanyRequest;
import com.example.inno.model.Employee;
import com.example.inno.model.UpdateCompanyRequest;
import com.example.inno.service.CompanyService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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
@Validated
@RestController
@RequestMapping("/v1/company")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(final CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping(
        value = "/{id}",
        produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Company> getCompany(@PathVariable("id") final long companyId) {
        final Company response = companyService.getCompany(companyId);
        return ResponseEntity.ok(response);
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List<Company>> getAllCompanies() {
        final List<Company> response = companyService.getAllCompanies();
        return ResponseEntity.ok(response);
    }

    @PutMapping(
        value = "/{id}",
        produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Employee> updateCompany(@PathVariable("id") final long companyId,
                                                  @RequestBody final UpdateCompanyRequest request) {
        companyService.updateCompany(companyId, request);
        return ResponseEntity.ok(null);
    }

    @PostMapping(
        consumes = APPLICATION_JSON_VALUE,
        produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Company> createCompany(@RequestBody final CreateCompanyRequest request,
                                                 final HttpServletRequest servletRequest) throws URISyntaxException {
        final long companyId = companyService.create(request);
        final Company created = companyService.getCompany(companyId);

        UriComponents location = UriComponentsBuilder
                .fromUriString(servletRequest.getRequestURL().toString())
                .path(Long.toString(created.getId()))
                .build();

        return ResponseEntity
                .created(new URI(location.toString()))
                .body(created);
    }

}
