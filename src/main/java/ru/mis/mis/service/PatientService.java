package ru.mis.mis.service;

import ru.mis.mis.dto.PatientDto;
import ru.mis.mis.model.Patient;

import java.util.Optional;

public interface PatientService {
    Optional<Object> getAll();
    Optional<Patient> findById(int id);
    PatientDto create(PatientDto patientDto);
    PatientDto updatePatient(PatientDto patientDto, int id);
    void patientDelete(int id);

}
