/**
 * CONFIDENTIAL INFORMATION
 * <p>
 * All Rights Reserved.  Unauthorized reproduction, transmission, or
 * distribution of this software is a violation of applicable laws.
 * <p>
 * Date: Jun 24, 2018
 * Copyright 2018 innoirvinge@gmail.com
 */
package com.example.inno.exception;

import lombok.*;

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
public class EntityNotFounException extends RuntimeException {

    private Long id;

}
