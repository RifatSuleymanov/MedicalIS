package ru.mis.mis.service.impl;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.mis.mis.dto.EmployeeDto;
import ru.mis.mis.exception.ModelNotFoundException;
import ru.mis.mis.exception.NotFoundException;
import ru.mis.mis.mapper.EmployeeMapper;
import ru.mis.mis.model.Employee;
import ru.mis.mis.repository.EmployeeRepository;
import ru.mis.mis.service.EmployeeService;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class EmployeeServiceImp implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImp(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Optional<Object> getAll() {
        List<Employee> employees = employeeRepository.findAll();
        if (employees.isEmpty()) {
            log.info("There is no Employee in the database.");
            return Optional.empty();
        }
        return Optional.of(employees);
    }

    @Override
    public Optional<Employee> findById(int id) {
        return Optional.ofNullable(employeeRepository.findById(id)
                .orElseThrow(() -> new ModelNotFoundException("Employee with id " + id + " not found.")));
    }

    @Override
    @Transactional
    public EmployeeDto create(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.INSTANCE.toEmployee(employeeDto);
        return EmployeeMapper.INSTANCE.toEmployeeDto(employeeRepository.save(employee));
    }

    @Override
    public EmployeeDto updateEmployee(EmployeeDto employeeDto, int id) {
        Employee employeeOriginal = employeeRepository.findById(id)
                .orElseThrow(() -> new ModelNotFoundException("No user ID"));

        Employee employee = EmployeeMapper.INSTANCE.toEmployee(employeeDto);

        Optional.ofNullable(employee.getName()).ifPresent(employeeOriginal::setName);
        Optional.ofNullable(employee.getLastName()).ifPresent(employeeOriginal::setLastName);
        Optional.ofNullable(employee.getMiddleName()).ifPresent(employeeOriginal::setMiddleName);
        Optional.ofNullable(employee.getPosition()).ifPresent(employeeOriginal::setPosition);
        Optional.ofNullable(employee.getDepartment()).ifPresent(employeeOriginal::setDepartment);
        Optional.ofNullable(employee.getEmail()).ifPresent(employeeOriginal::setEmail);
        Optional.ofNullable(employee.getDateOfEmployment()).ifPresent(employeeOriginal::setDateOfEmployment);

        return EmployeeMapper.INSTANCE.toEmployeeDto(employeeRepository.save(employeeOriginal));
    }

    @Override
    public void employeeDelete(int id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ModelNotFoundException("No user ID"));
        employeeRepository.delete(employee);
    }
}