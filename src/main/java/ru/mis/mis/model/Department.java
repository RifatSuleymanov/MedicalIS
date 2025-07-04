package ru.mis.mis.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    @JoinColumn(name = "department_manager")
    private Employee manager;

    //Сотрудники
    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"department", "hibernateLazyInitializer", "handler"})
    private List<Employee> employees;


}
