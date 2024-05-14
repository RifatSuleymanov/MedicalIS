package ru.rkod.rkod.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.rkod.rkod.dto.EmployeeDto;
import ru.rkod.rkod.model.Employee;
import ru.rkod.rkod.service.EmployeeService;

import java.util.List;

@Controller
@RequestMapping("/")
@AllArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("employees")
    public List<Employee> getAll() {
        return employeeService.getAll();
    }

    @PostMapping("add")
    public void addEmployee(EmployeeDto employeeDto){
        employeeService.addEmployee(employeeDto);
    }
}
