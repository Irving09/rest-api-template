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

import com.example.inno.config.CompanyServiceConfig;
import com.example.inno.model.Company;
import com.example.inno.model.CreateCompanyRequest;
import com.example.inno.model.UpdateCompanyRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Arrays;
import java.util.List;

/**
 * @author irving09 <innoirvinge@gmail.com>
 */
@Service
public class CompanyService {

    @Autowired
    private CompanyServiceConfig config;

    @Autowired
    private RestTemplate httpClient;

    public List<Company> getAllCompanies() {
        String resourceUri = String.format("%s/companies", config.getCompanyServiceHost());

        Company[] companies = httpClient
                .getForEntity(resourceUri, Company[].class)
                .getBody();

        return Arrays.asList(companies);
    }

    public long create(final CreateCompanyRequest request) {
        throw new NotImplementedException();
    }

    public Company getCompany(final long companyId) {
        String resourceUri = String.format("%s/companies/%d", config.getCompanyServiceHost(), companyId);
        return httpClient
                .getForEntity(resourceUri, Company.class)
                .getBody();
    }

    public void updateCompany(long companyId, UpdateCompanyRequest request) {
        throw new NotImplementedException();
    }

}
