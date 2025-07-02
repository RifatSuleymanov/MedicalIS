package ru.mis.mis.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.mis.mis.dto.DepartmentDto;
import ru.mis.mis.model.Department;

@Mapper
public interface DepartmentMapper {
    DepartmentMapper INSTANCE = Mappers.getMapper(DepartmentMapper.class);

    DepartmentDto toDepartmentDto(Department department);
    Department toDepartment(DepartmentDto departmentDto);
}
