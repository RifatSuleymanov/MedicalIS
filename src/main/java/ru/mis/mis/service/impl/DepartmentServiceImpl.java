package ru.mis.mis.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.mis.mis.dto.DepartmentDto;
import ru.mis.mis.model.Department;
import ru.mis.mis.service.DepartmentService;

import java.util.Optional;

@Slf4j
@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Override
    public Optional<Object> getAll() {
        return Optional.empty();
    }

    @Override
    public Optional<Department> findById(int id) {
        return Optional.empty();
    }

    @Override
    public DepartmentDto create(DepartmentDto departmentDto) {
        return null;
    }

    @Override
    public DepartmentDto updateDepartment(DepartmentDto departmentDto, int id) {
        return null;
    }

    @Override
    public void departmentDelete(int id) {

    }
}
