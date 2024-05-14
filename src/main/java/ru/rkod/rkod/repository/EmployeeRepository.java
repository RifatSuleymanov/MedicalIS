package ru.rkod.rkod.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.rkod.rkod.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
