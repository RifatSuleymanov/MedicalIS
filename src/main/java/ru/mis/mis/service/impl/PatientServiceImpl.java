package ru.mis.mis.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.mis.mis.dto.PatientDto;
import ru.mis.mis.exception.ModelNotFoundException;
import ru.mis.mis.mapper.PatientMapper;
import ru.mis.mis.model.Patient;
import ru.mis.mis.repository.PatientRepository;
import ru.mis.mis.service.PatientService;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;


    @Override
    public Optional<Object> getAll() {
        List<Patient> patient = patientRepository.findAll();
        if (patient.isEmpty()) {
            log.info("No patients found");
            return Optional.empty();
        }
        return Optional.of(patient);
    }

    @Override
    public Optional<Patient> findById(int id) {
        return Optional.ofNullable(patientRepository.findById(id)
                .orElseThrow(() -> new ModelNotFoundException("Patient with id " + id + " not found")));
    }

    @Override
    @Transactional
    public PatientDto create(PatientDto patientDto) {
        Patient patient = PatientMapper.INSTANCE.toPatient(patientDto);
        return PatientMapper.INSTANCE.toPatientDto(patientRepository.save(patient));
    }

    @Override
    public PatientDto updatePatient(PatientDto patientDto, int id) {
        Patient patientOriginal = patientRepository.findById(id)
                .orElseThrow(() -> new ModelNotFoundException("No user ID"));
        Patient patient = PatientMapper.INSTANCE.toPatient(patientDto);

        Optional.ofNullable(patient.getName()).ifPresent(patientOriginal::setName);
        Optional.ofNullable(patient.getLastName()).ifPresent(patientOriginal::setLastName);
        Optional.ofNullable(patient.getMiddleName()).ifPresent(patientOriginal::setMiddleName);
        Optional.ofNullable(patient.getGender()).ifPresent(patientOriginal::setGender);
        Optional.ofNullable(patient.getEmail()).ifPresent(patientOriginal::setEmail);
        Optional.ofNullable(patient.getPhoneNumber()).ifPresent(patientOriginal::setPhoneNumber);
        Optional.ofNullable(patient.getBirthDate()).ifPresent(patientOriginal::setBirthDate);
        Optional.ofNullable(patient.getSnils()).ifPresent(patientOriginal::setSnils);
        Optional.ofNullable(patient.getPolicyNumber()).ifPresent(patientOriginal::setPolicyNumber);

        return PatientMapper.INSTANCE.toPatientDto(patientRepository.save(patientOriginal));
    }

    @Override
    public void patientDelete(int id) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new ModelNotFoundException("Patient with id " + id + " not found"));
        patientRepository.delete(patient);

    }
}
