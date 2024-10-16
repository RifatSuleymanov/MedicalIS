/**
 * ----------------------------------------------
 * /* Author: Rifat Suleymanov
 * /* Date: 2024-10-16 11:16
 * ----------------------------------------------
 */
package ru.rkod.rkod.exception;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(String message) {
        super(message);
    }
}
