package ru.rkod.rkod.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.rkod.rkod.dto.EmployeeDto;
import ru.rkod.rkod.model.Employee;

@Mapper
public interface EmployeeMapper {
    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    EmployeeDto toEmployeeDto(Employee employee);

    Employee toEmployee(EmployeeDto employeeDto);
}
