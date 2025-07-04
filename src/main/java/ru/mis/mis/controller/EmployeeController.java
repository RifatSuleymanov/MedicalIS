package ru.mis.mis.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.mis.mis.dto.EmployeeDto;
import ru.mis.mis.model.Employee;
import ru.mis.mis.service.EmployeeService;

import java.util.Optional;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("")
    public Optional<Object> getAll() {
        log.info("method getAll()");
        return employeeService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Employee> findById(@PathVariable int id) {
        log.info("method findById({})", id);
        return employeeService.findById(id);
    }

    @PostMapping("")
    public EmployeeDto addEmployee(@RequestBody EmployeeDto employeeDto) {
        log.info("method addEmployee()");
        return employeeService.create(employeeDto);
    }

    @PatchMapping("/{id}")
    public EmployeeDto updateEmployee(@RequestBody EmployeeDto employeeDto, @PathVariable Integer id) {
        log.info("method updateEmployee() employeeId {}", id);
        return employeeService.updateEmployee(employeeDto, id);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Integer id) {
        log.info("method employeeDelete employeeId {}", id);
        employeeService.employeeDelete(id);
    }
}