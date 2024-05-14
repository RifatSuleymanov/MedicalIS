package ru.rkod.rkod.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;

@Data
@Entity
@Validated
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; //id
    private String name; // Имя
    private String lastName; // Фамилия
//    private String middleName; // Отчество
//    private String position; // Должность
//    private Department department; // Отделение
//    private String email;
//    private LocalDate dateOfEmployment; // Дата приемна на работу
//    private LocalDate dateOfDismissal; // Дата увольнения
}