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
import com.example.inno.model.CreateCompanyRequest;
import com.example.inno.model.CreateEmployeeRequest;
import com.example.inno.model.Employee;
import com.example.inno.model.UpdateCompanyRequest;
import com.example.inno.model.UpdateEmployeeRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author irving09 <innoirvinge@gmail.com>
 */
@Service
public class CompanyService {

    public List<Company> getAllCompanies() {
        // TODO make call to db here
        List<Company> companies = new ArrayList<>();
        companies.add(getCompany(123));
        return companies;
    }

    public Employee getEmployee(final long companyId, final long employeeId) {
        // TODO make call to db here using id
        return Employee.builder()
                .id(employeeId)
                .firstName("inno")
                .lastName("estrera")
                .company(Company.builder()
                        .id(ThreadLocalRandom.current().nextLong(1, Long.MAX_VALUE))
                        .name("CDK Digital Marketing")
                        .address("605 5th Ave S #800, Seattle, WA 98104")
                        .build())
                .build();
    }

    public List<Employee> getAllEmployees(final long companyId) {
        // TODO make call to db here using id
        List<Employee> employees = new ArrayList<>();
        return employees;
    }

    public long createEmployee(final CreateEmployeeRequest request) {
        // TODO make call to db here using id
        // TODO make service level validation
        return ThreadLocalRandom.current().nextLong(1, Long.MAX_VALUE);
    }

    public long updateEmployee(final long companyId, final long employeeId, final UpdateEmployeeRequest request) {
        // TODO make call to db here using id
        // TODO make service level validation
        return ThreadLocalRandom.current().nextLong(1, Long.MAX_VALUE);
    }

    public long create(final CreateCompanyRequest request) {
        // TODO make call to db here using id
        // TODO make service level validation
        return ThreadLocalRandom.current().nextLong(1, Long.MAX_VALUE);
    }

    public Company getCompany(final long companyId) {
        // TODO make call to db here using id
        return Company.builder()
                .id(companyId)
                .address("605 5th Ave S #800, Seattle, WA 98104")
                .name("CDK Digital Marketing")
                .build();
    }

    public void updateCompany(long companyId, UpdateCompanyRequest request) {
        // TODO make call to db here using id and request
    }
}
