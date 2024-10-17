package ru.mis.mis.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.mis.mis.dto.EmployeeDto;
import ru.mis.mis.model.Employee;

@Mapper
public interface EmployeeMapper {
    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    EmployeeDto toEmployeeDto(Employee employee);

    Employee toEmployee(EmployeeDto employeeDto);
}