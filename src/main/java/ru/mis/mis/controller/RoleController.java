package ru.mis.mis.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.mis.mis.dto.RoleDto;
import ru.mis.mis.model.Role;
import ru.mis.mis.service.RoleService;

import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/role")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @GetMapping("")
    public Optional<Object> getAll() {
        log.info("method getAll() role");
        return roleService.gatAll();
    }

    @GetMapping("/{id}")
    public Optional<Role> findById(@PathVariable int id) {
        log.info("method getById(int id) role");
        return roleService.findById(id);
    }

    @PostMapping("")
    public RoleDto addRole(@RequestBody RoleDto roleDto) {
        log.info("method addRole(RoleDto roleDto) role");
        return roleService.create(roleDto);
    }

    @PatchMapping("/{id}")
    public RoleDto updateRole(@PathVariable int id, @RequestBody RoleDto roleDto) {
        log.info("method updateRole(RoleDto roleDto) role");
        return roleService.updateRole(roleDto, id);
    }

    @DeleteMapping("/{id}")
    public void deleteRole(@PathVariable int id) {
        log.info("method deleteRole(RoleDto roleDto) role");
        roleService.roleDelete(id);
    }
}
