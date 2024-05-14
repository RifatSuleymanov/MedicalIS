package ru.rkod.rkod.service.impl;

import org.springframework.stereotype.Service;
import ru.rkod.rkod.dto.EmployeeDto;
import ru.rkod.rkod.mapper.EmployeeMapper;
import ru.rkod.rkod.model.Employee;
import ru.rkod.rkod.repository.EmployeeRepository;
import ru.rkod.rkod.service.EmployeeService;

import java.util.List;

@Service
public class EmployeeServiceImp implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImp(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public EmployeeDto addEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.toEmployee(employeeDto);
        return EmployeeMapper.toEmployeeDto(employeeRepository.save(employee));
    }
}