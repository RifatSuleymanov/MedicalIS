package ru.rkod.rkod.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.relational.core.sql.In;
import ru.rkod.rkod.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
