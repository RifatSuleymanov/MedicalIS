package ru.mis.mis.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;
import java.util.Set;

@Data
@Entity
@Validated
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "First name must not be empty!")
    @Size(min = 2, max = 30, message = "First name must be between 2 and 30 characters long.")
    @Column(name = "name")
    private String name;
    @NotEmpty(message = "Last name must not be empty!")
    @Size(min = 2, max = 30, message = "Last name must be between 2 and 30 characters.")
    @Column(name = "lastname")
    private String lastName;
    @Column(name = "patronymic")
    private String middleName;
    @NotBlank
    @Column(name = "position")
    private String position;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", nullable = true)
    @JsonIgnoreProperties({"employees", "hibernateLazyInitializer", "handler"})
    private Department department;
    @Email(message = "Email должен быть валидным: *****@***.ru")
    @NotEmpty(message = "Email must not be empty!")
    private String email;
    @Column(name = "dateOfEmployment")
    private LocalDate dateOfEmployment;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "employee_roles",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles;
}