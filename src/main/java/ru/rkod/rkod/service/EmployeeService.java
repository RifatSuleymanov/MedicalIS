package ru.rkod.rkod.service;

import ru.rkod.rkod.dto.EmployeeDto;
import ru.rkod.rkod.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAll();

    EmployeeDto create(EmployeeDto employeeDto);

    EmployeeDto updateEmployee(EmployeeDto employeeDto, int id);

    void employeeDelete(int id);
}