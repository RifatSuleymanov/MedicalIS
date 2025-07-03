package ru.mis.mis.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.mis.mis.model.Department;
import ru.mis.mis.model.Employee;

import java.time.LocalDate;

@Data
@NoArgsConstructor(force = true)
public class EmployeeDto {
    private Integer id;
    private String name;
    private String lastName;
    private String middleName;
    private String position;
    private Integer departmentId;
    private String email;
    private LocalDate dateOfEmployment;
}