package ru.mis.mis.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.mis.mis.model.Employee;

import java.util.List;

@Data
@NoArgsConstructor(force = true)
public class DepartmentDto {
    private Long id;
    private String name;
    private String description;
    private List<Employee> employees;
}
