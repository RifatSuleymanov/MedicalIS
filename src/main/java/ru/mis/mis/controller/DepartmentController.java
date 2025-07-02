package ru.mis.mis.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.mis.mis.service.DepartmentService;

@RestController("/department")
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentService departmentService;

}
