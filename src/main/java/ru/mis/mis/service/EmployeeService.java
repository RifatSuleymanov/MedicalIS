package ru.mis.mis.service;

import ru.mis.mis.dto.EmployeeDto;
import ru.mis.mis.model.Employee;

import java.util.Optional;

public interface EmployeeService {
    Optional<Object> getAll();

    Optional<Employee> findById(int id);

    EmployeeDto create(EmployeeDto employeeDto);

    EmployeeDto updateEmployee(EmployeeDto employeeDto, int id);

    void employeeDelete(int id);
}
