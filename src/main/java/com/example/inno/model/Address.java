/**
 * CONFIDENTIAL INFORMATION
 * <p>
 * All Rights Reserved.  Unauthorized reproduction, transmission, or
 * distribution of this software is a violation of applicable laws.
 * <p>
 * Date: Jun 24, 2018
 * Copyright 2018 innoirvinge@gmail.com
 */
package com.example.inno.model;

import lombok.*;
import org.hibernate.validator.constraints.Length;

/**
 * @author irving09 <innoirvinge@gmail.com>
 */
@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    private String street;

    private String city;

    private String state;

    @Length(min=5, max=5)
    private String zipCode;

}
