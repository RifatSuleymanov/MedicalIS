package ru.rkod.rkod;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.rkod.rkod.model.Employee;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static ru.rkod.rkod.model.Department.IT;

@SpringBootApplication
public class RkodApplication {

    public static void main(String[] args) {
        SpringApplication.run(RkodApplication.class, args);
        Calendar calendar = new GregorianCalendar(2017, Calendar.JANUARY , 25);
        Employee employee = new Employee();
        employee.setId(1);
        employee.setName("Rifat");
        employee.setLastName("Suleymanov");
        employee.setMiddleName("Raufanovich");
        employee.setPosition("Admin");
        employee.setDepartment(IT);
        employee.setEmail("fc.chelsea@yandex.ru");
        employee.setDateOfEmployment(LocalDate.of(2021,05,15));

        System.out.println(employee);
    }

}
