package ru.mis.mis.service.impl;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.mis.mis.dto.PatientDto;
import ru.mis.mis.exception.ModelNotFoundException;
import ru.mis.mis.exception.NotFoundException;
import ru.mis.mis.mapper.PatientMapper;
import ru.mis.mis.model.Patient;
import ru.mis.mis.repository.PatientRepository;
import ru.mis.mis.service.PatientService;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

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
                .orElseThrow(()-> new ModelNotFoundException("Patient with id " + id + " not found")));
    }

    @Override
    @Transactional
    public PatientDto create(PatientDto patientDto) {
        Patient patient = PatientMapper.INSTANCE.toPatient(patientDto);
        return PatientMapper.INSTANCE.toPatientDto(patientRepository.save(patient));
    }

    @Override
    public PatientDto updatePatient(PatientDto patientDto, int id) {
        return null;
    }

    @Override
    public void patientDelete(int id) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(()-> new ModelNotFoundException("Patient with id " + id + " not found"));
        patientRepository.delete(patient);

    }
}
