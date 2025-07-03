package ru.mis.mis.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.mis.mis.dto.DepartmentDto;
import ru.mis.mis.dto.EmployeeDto;
import ru.mis.mis.exception.ModelNotFoundException;
import ru.mis.mis.mapper.DepartmentMapper;
import ru.mis.mis.model.Department;
import ru.mis.mis.model.Employee;
import ru.mis.mis.repository.DepartmentRepository;
import ru.mis.mis.repository.EmployeeRepository;
import ru.mis.mis.service.DepartmentService;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;

    @Override
    public Optional<Object> getAll() {
        List<Department> departments = departmentRepository.findAll();
        if(departments.isEmpty()) {
            log.info("No department found");
            return Optional.empty();
        }
        return Optional.of(departments);
    }

    @Override
    public Optional<Department> findById(int id) {
        return Optional.ofNullable(departmentRepository.findById(id)
                .orElseThrow(() -> new ModelNotFoundException("Department with id " + id + " not found")));
    }

    @Override
    public DepartmentDto create(DepartmentDto departmentDto) {
        Department department = DepartmentMapper.INSTANCE.toDepartment(departmentDto);
        return DepartmentMapper.INSTANCE.toDepartmentDto(departmentRepository.save(department));
    }

    @Override
    public DepartmentDto updateDepartment(DepartmentDto departmentDto, int id) {
        return null;
    }

    @Override
    public void departmentDelete(int id) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new ModelNotFoundException("Отдел с id " + id + " не найден"));

        //Отвязываем сотрудников от отдела
        List<EmployeeDto> employeesList = employeeRepository.findByDepartment(department);
        for(EmployeeDto empDto : employeesList) {
            empDto.setDepartment(null);
            employeeRepository.save(empDto);
        }
        // Удаляем отдел
        departmentRepository.delete(department);
    }
}
