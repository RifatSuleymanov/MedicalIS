package ru.mis.mis.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.mis.mis.dto.DepartmentDto;
import ru.mis.mis.model.Department;
import ru.mis.mis.service.DepartmentService;

import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/department")
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentService departmentService;

    @GetMapping("")
    public Optional<Object> getAll(){
        log.info("method getAll() department");
        return departmentService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Department> findById(@PathVariable int id){
        log.info("method findById(int id) department");
        return departmentService.findById(id);
    }

    @PostMapping("")
    public DepartmentDto addDepartment(@RequestBody DepartmentDto departmentDto){
        log.info("method addDepartment(DepartmentDto departmentDto) departmentDto");
        return departmentService.create(departmentDto);
    }

    @PatchMapping("/{id}")
    public DepartmentDto updateDepartment(@PathVariable int id, @RequestBody DepartmentDto departmentDto){
        log.info("method updateDepartment(DepartmentDto departmentDto) departmentDto");
        return departmentService.updateDepartment(departmentDto, id);
    }

    @DeleteMapping("/{id}")
    public void deleteDepartment(@PathVariable int id){
        log.info("method deleteDepartment(DepartmentDto departmentDto) departmentDto");
        departmentService.departmentDelete(id);
    }

}
