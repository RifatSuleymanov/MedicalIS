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
    @NotEmpty(message = "Имя не должно быть пустым!")
    @Size(min = 2, max = 30, message = "Имя должно быть от 2-х до 30-ти символов")
    @Column(name = "name")
    private String name; // Имя
    @NotEmpty(message = "Фамилия не должно быть пустым!")
    @Size(min = 2, max = 30, message = "Фамилия должно быть от 2-х до 30-ти символов")
    @Column(name = "lastname")
    private String lastName; // Фамилия
    @Column(name = "patronymic")
    private String middleName; // Отчество
    @NotBlank
    @Column(name = "position")
    private String position; // Должность
    @Column(name = "department")
    private Department department; // Отделение
    @Email(message = "Email должые быть валидным: *****@***.ru")
    @NotEmpty(message = "Email не должно быть пустым!")
    private String email;
    @Column(name = "dateofemployment")
    private LocalDate dateOfEmployment; // Дата приемна на работу
}