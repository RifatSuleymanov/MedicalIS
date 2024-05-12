package ru.rkod.rkod.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

@Data
@Entity
@Validated
@Table(name = "bookings")
public class Employee {
    @Id
    private Integer id; //id
    @NotBlank
    @Min(value = 3)
    @Max(value = 15)
    private String name; // Имя
    @NotBlank
    @Min(value = 3)
    @Max(value = 15)
    private String lastName; // Фамилия
    @NotBlank
    @Min(value = 3)
    @Max(value = 15)
    private String middleName; // Отчество
    @NotBlank
    private String position; // Должность
    @NotBlank
    private Department department; // Отделение
    @Email
    @NotBlank
    private String email;
    @NotBlank
    private LocalDate dateOfEmployment; // Дата приемна на работу
    private LocalDate dateOfDismissal; // Дата увольнения
}