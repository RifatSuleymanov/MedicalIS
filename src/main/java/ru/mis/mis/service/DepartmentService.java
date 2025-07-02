package ru.mis.mis.service;

import ru.mis.mis.dto.DepartmentDto;
import ru.mis.mis.model.Department;

import java.util.Optional;

public interface DepartmentService {
    Optional<Object> getAll();
    Optional<Department> findById(int id);
    DepartmentDto create(DepartmentDto departmentDto);
    DepartmentDto updateDepartment(DepartmentDto departmentDto, int id);
    void departmentDelete(int id);
}
