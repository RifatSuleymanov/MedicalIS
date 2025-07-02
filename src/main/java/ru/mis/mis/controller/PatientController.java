package ru.mis.mis.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.mis.mis.dto.PatientDto;
import ru.mis.mis.model.Patient;
import ru.mis.mis.service.PatientService;

import java.util.Optional;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/patient")
public class PatientController {

    private final PatientService patientService;

    @GetMapping("")
    public Optional<Object> getAll(){
        log.info("method getAll().Patient");
        return patientService.getAll();
    }

    @GetMapping("/{id{}")
    public Optional<Patient> findById(@PathVariable int id){
        log.info("method findById({}).Patient", id);
        return patientService.findById(id);
    }

    @PostMapping("/{id}")
    public PatientDto updatePatient(@RequestBody PatientDto patientDto, @PathVariable Integer id) {
        log.info("method updatePatient() patientId {}", id);
        return patientService.updatePatient(patientDto, id);
    }

    @DeleteMapping("/{id}")
    public void deletePatietnt(@PathVariable Integer id){
        log.info("method patientDelete patientId {}", id);
        patientService.patientDelete(id);
    }
}
