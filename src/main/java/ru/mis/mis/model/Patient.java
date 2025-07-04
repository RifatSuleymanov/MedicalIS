package ru.mis.mis.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;

@Data
@Entity
@Validated
@Table(name = "patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "First name must not be empty!")
    @Size(min = 2, max = 30, message = "First name must be between 2 and 30 characters long.")
    @Column(name = "namePatient")
    private String name;
    @NotEmpty(message = "Last name must not be empty!")
    @Size(min = 2, max = 30, message = "Last name must be between 2 and 30 characters.")
    @Column(name = "lastnamePatien")
    private String lastName;
    @Column(name = "middleNamePatient")
    private String middleName;
    @Enumerated(EnumType.STRING)
    @Column(name = "gender", length = 1)
    @NotNull(message = "Gender must not be null")
    private Gender gender;
    @Email(message = "Email должен быть валидным: *****@***.ru")
    @NotEmpty(message = "Email must not be empty!")
    private String email;
    @NotEmpty(message = "Phone number must not be empty")
    @Pattern(regexp = "^\\+7\\d{10}$", message = "Phone number must match +7XXXXXXXXXX")
    @Column(name = "phone_number_patient")
    private String phoneNumber;
    @Past(message = "Birth date must be in the past")
    @NotNull(message = "Birth date must not be null")
    @Column(name = "birth_date_patient")
    private LocalDate birthDate;
    @NotEmpty(message = "SNILS must not be empty")
    @Pattern(regexp = "^\\d{11}$", message = "SNILS must be 11 digits")
    @Column(name = "snils_patient", unique = true)
    private String snils;
    @NotEmpty(message = "Insurance policy number must not empty")
    @Pattern(regexp = "^\\d{16}$", message = "Insurance policy number must be 16 digits")
    @Column(name = "policy_number_patient", unique = true)
    private String policyNumber;
}
