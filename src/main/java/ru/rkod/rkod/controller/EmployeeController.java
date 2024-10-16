package ru.rkod.rkod.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.rkod.rkod.dto.EmployeeDto;
import ru.rkod.rkod.model.Employee;
import ru.rkod.rkod.service.EmployeeService;

import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("")
    public List<Employee> getAll() {
        log.info("метод getAll()");
        return employeeService.getAll();
    }

    @PostMapping("")
    public EmployeeDto addEmployee(@RequestBody EmployeeDto employeeDto) {
        log.info("метод addEmployee()");
        return employeeService.create(employeeDto);
    }

    @PatchMapping("/{id}")
    public EmployeeDto updateEmployee(@RequestBody EmployeeDto employeeDto, @PathVariable Integer id) {
        log.info("метод updateEmployee() employeeId {}", id);
        return employeeService.updateEmployee(employeeDto, id);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Integer id){
        log.info("метод employeeDelete employeeId {}", id);
        employeeService.employeeDelete(id);
    }
}