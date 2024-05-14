package ru.rkod.rkod;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.rkod.rkod.model.Employee;
import ru.rkod.rkod.repository.EmployeeRepository;
import ru.rkod.rkod.service.EmployeeService;
import ru.rkod.rkod.service.impl.EmployeeServiceImp;

@SpringBootApplication
public class RkodApplication {
    public static void main(String[] args) {
        SpringApplication.run(RkodApplication.class, args);
    }

}
