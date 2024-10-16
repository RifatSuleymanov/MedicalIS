package ru.rkod.rkod.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.rkod.rkod.model.Department;
import ru.rkod.rkod.model.Employee;

import java.time.LocalDate;

@Data
@NoArgsConstructor(force = true)
public class EmployeeDto extends Employee {
    private Integer id; //id
    public String name; // Имя
    public String lastName; // Фамилия
    private String middleName; // Отчество
    private String position; // Должность
    private Department department; // Отделение
    private String email; // email
    private LocalDate dateOfEmployment; // Дата приемна на работу
}
