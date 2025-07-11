package ru.mis.mis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mis.mis.model.Department;
import ru.mis.mis.model.Employee;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findByDepartment(Department department);
}
