package ru.mis.mis.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(force = true)
public class RoleDto {
    private Integer id;
    private String name;
    private String description;
}
