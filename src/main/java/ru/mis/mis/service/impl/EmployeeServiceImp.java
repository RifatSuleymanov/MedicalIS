package ru.mis.mis.service.impl;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.mis.mis.dto.EmployeeDto;
import ru.mis.mis.exception.ModelNotFoundException;
import ru.mis.mis.exception.NotFoundException;
import ru.mis.mis.mapper.EmployeeMapper;
import ru.mis.mis.model.Department;
import ru.mis.mis.model.Employee;
import ru.mis.mis.repository.DepartmentRepository;
import ru.mis.mis.repository.EmployeeRepository;
import ru.mis.mis.service.EmployeeService;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class EmployeeServiceImp implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    public EmployeeServiceImp(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
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

        if(employeeDto.getName() != null) employeeOriginal.setName(employeeDto.getName());
        if(employeeDto.getLastName() != null) employeeOriginal.setLastName(employeeDto.getLastName());
        if(employeeDto.getMiddleName() != null) employeeOriginal.setMiddleName(employeeDto.getMiddleName());
        if(employeeDto.getPosition() != null) employeeOriginal.setPosition(employeeDto.getPosition());
        if(employeeDto.getDepartmentId() != null) {
            Department dep = departmentRepository.findById(employeeDto.getDepartmentId())
                    .orElseThrow(() -> new ModelNotFoundException("Department not found"));
            employeeOriginal.setDepartment(dep);
        }
        if (employeeDto.getEmail() != null) employeeOriginal.setEmail(employeeDto.getEmail());
        if (employeeDto.getDateOfEmployment() != null) employeeOriginal.setDateOfEmployment(employeeDto.getDateOfEmployment());

        return EmployeeMapper.INSTANCE.toEmployeeDto(employeeRepository.save(employeeOriginal));


    }

    @Override
    public void employeeDelete(int id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ModelNotFoundException("No user ID"));
        employeeRepository.delete(employee);
    }
}