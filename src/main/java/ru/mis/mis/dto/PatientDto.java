package ru.mis.mis.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.mis.mis.model.Patient;

import java.time.LocalDate;

@Data
@NoArgsConstructor(force = true)
public class PatientDto {
    private Integer id;
    private String name;
    private String lastName;
    private String middleName;
    private String gender;
    private String email;
    private String phoneNumber;
    private LocalDate birthDate;
    private String snils;
    private String policyNumber;

}
