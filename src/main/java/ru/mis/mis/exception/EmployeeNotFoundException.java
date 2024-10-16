/**
 * ----------------------------------------------
 * /* Author: Rifat Suleymanov
 * /* Date: 2024-10-16 11:16
 * ----------------------------------------------
 */
package ru.mis.mis.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(String message) {
        super(message);
        log.warn(message);
    }
}