package ru.mis.mis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mis.mis.dto.DepartmentDto;
import ru.mis.mis.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
