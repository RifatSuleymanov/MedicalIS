package ru.rkod.rkod.mapper;

import ru.rkod.rkod.dto.EmployeeDto;
import ru.rkod.rkod.model.Employee;

public class EmployeeMapper {
    public static EmployeeDto toEmployeeDto(Employee employee){
        EmployeeDto dto = new EmployeeDto();
        dto.setId(dto.getId());
        dto.setName(dto.getName());
        dto.setLastName(dto.getLastName());
        dto.setMiddleName(dto.getMiddleName());
        dto.setPosition(dto.getPosition());
        dto.setDepartment(dto.getDepartment());
        dto.setEmail(dto.getEmail());
        dto.setDateOfEmployment(dto.getDateOfEmployment());
        dto.setDateOfDismissal(dto.getDateOfDismissal());
        return dto;
    }

    public static Employee toEmployee(EmployeeDto employeeDto){
        Employee employee = new Employee();
        employee.setId(employee.getId());
        employee.setName(employee.getName());
        employee.setLastName(employee.getLastName());
        employee.setMiddleName(employee.getMiddleName());
        employee.setPosition(employee.getPosition());
        employee.setDepartment(employee.getDepartment());
        employee.setEmail(employee.getEmail());
        employee.setDateOfEmployment(employee.getDateOfEmployment());
        employee.setDateOfDismissal(employee.getDateOfDismissal());
        return employee;
    }
}
