package ru.mis.mis.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "role_name", nullable = false, unique = true)
    private String name;

    @Column(name = "role_description")
    private String description;

    //связь с пользователем
    @ManyToMany(mappedBy = "roles")
    private Set<Employee> employees;
}
