package ru.mis.mis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mis.mis.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
}
