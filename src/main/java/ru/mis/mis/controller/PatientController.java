package ru.mis.mis.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mis.mis.service.PatientService;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("patient")
public class PatientController {

    private final PatientService patientService;
}
