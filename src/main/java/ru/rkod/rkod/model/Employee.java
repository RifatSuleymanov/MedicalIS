package ru.rkod.rkod.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;

@Data
@Entity
@Validated
@Table(name = "bookings")
public class Employee {
    @Id
    private Integer id; //id
    @NotEmpty(message = "Имя не должно быть пустым!")
    @Size(min = 2, max = 30, message = "Имя должно быть от 2-х до 30-ти символов")
    private String name; // Имя
    @NotEmpty(message = "Фамилия не должно быть пустым!")
    @Size(min = 2, max = 30, message = "Фамилия должно быть от 2-х до 30-ти символов")
    private String lastName; // Фамилия
    private String middleName; // Отчество
    @NotBlank
    private String position; // Должность
    @NotBlank
    private Department department; // Отделение
    @Email(message = "Email должые быть валидным: *****@***.ru")
    @NotEmpty(message = "Email не должно быть пустым!")
    private String email;
    @NotBlank
    private LocalDate dateOfEmployment; // Дата приемна на работу
    private LocalDate dateOfDismissal; // Дата увольнения
}