package ru.mis.mis.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "department_name", nullable = false, unique = true)
    private String name;

    @Column(name = "department_description", nullable = false)
    private String description;

    //Руководитель
    @ManyToOne
    @Column(name = "department_manager")
    private Employee manager;

    //Сотрудники
    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
    @Column(name = "department_employees")
    private List<Employee> employees;


}
