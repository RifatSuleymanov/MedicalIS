package ru.mis.mis.service;

import ru.mis.mis.dto.RoleDto;
import ru.mis.mis.model.Role;

import java.util.Optional;

public interface RoleService {
    Optional<Object> gatAll();
    Optional<Role> findById(int id);
    RoleDto create(RoleDto roleDto);
    RoleDto updateRole(RoleDto roleDto, int id);
    void roleDelete(int id);
}
