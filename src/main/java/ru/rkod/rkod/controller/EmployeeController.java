package ru.rkod.rkod.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.rkod.rkod.dto.EmployeeDto;
import ru.rkod.rkod.model.Employee;
import ru.rkod.rkod.service.EmployeeService;

import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("")
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getAll() {
        log.info("метод getAll()");
        return employeeService.getAll();
    }

    @PostMapping("/add")
    public EmployeeDto addEmployee(@RequestBody EmployeeDto employeeDto) {
        log.info("метод addEmployee()");
        return employeeService.create(employeeDto);
    }
}
