package ru.rkod.rkod.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import ru.rkod.rkod.model.Department;

import java.time.LocalDate;

@Data
@SuperBuilder
@NoArgsConstructor(force = true)
public class EmployeeDto {

    private Integer id; //id
    private String name; // Имя
    private String lastName; // Фамилия
    private String middleName; // Отчество
    private String position; // Должность
    private Department department; // Отделение
    private String email; // email
    private LocalDate dateOfEmployment; // Дата приемна на работу
    private LocalDate dateOfDismissal; // Дата увольнения
}
