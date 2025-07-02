package ru.mis.mis.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.mis.mis.service.RoleService;

@RestController("/role")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;
}
