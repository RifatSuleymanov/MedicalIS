package ru.mis.mis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mis.mis.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
