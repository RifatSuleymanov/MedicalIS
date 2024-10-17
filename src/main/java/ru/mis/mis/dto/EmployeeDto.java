package ru.mis.mis.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.mis.mis.model.Department;
import ru.mis.mis.model.Employee;

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