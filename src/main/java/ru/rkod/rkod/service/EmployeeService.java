package ru.rkod.rkod.service;

import ru.rkod.rkod.dto.EmployeeDto;
import ru.rkod.rkod.model.Employee;

import java.util.Optional;

public interface EmployeeService {
    Optional<Object> getAll();

    Optional<Employee> findById(int id);

    EmployeeDto create(EmployeeDto employeeDto);

    EmployeeDto updateEmployee(EmployeeDto employeeDto, int id);

    void employeeDelete(int id);
}