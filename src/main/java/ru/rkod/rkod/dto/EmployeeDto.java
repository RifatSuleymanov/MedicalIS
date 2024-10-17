package ru.rkod.rkod.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.rkod.rkod.model.Department;
import ru.rkod.rkod.model.Employee;

import java.time.LocalDate;

@Data
@NoArgsConstructor(force = true)
public class EmployeeDto extends Employee {
    private Integer id;
    public String name;
    public String lastName;
    private String middleName;
    private String position;
    private Department department;
    private String email;
    private LocalDate dateOfEmployment;
}
