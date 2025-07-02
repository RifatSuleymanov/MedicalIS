package ru.mis.mis.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(force = true)
public class DepartmentDto {
    private Long id;
    private String name;
    private String description;
}
