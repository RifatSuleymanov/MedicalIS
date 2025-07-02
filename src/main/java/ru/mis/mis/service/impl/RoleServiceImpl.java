package ru.mis.mis.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.mis.mis.dto.RoleDto;
import ru.mis.mis.model.Role;
import ru.mis.mis.service.RoleService;

import java.util.Optional;

@Slf4j
@Service
public class RoleServiceImpl implements RoleService {
    @Override
    public Optional<Object> gatAll() {
        return Optional.empty();
    }

    @Override
    public Optional<Role> findById(int id) {
        return Optional.empty();
    }

    @Override
    public RoleDto create(RoleDto roleDto) {
        return null;
    }

    @Override
    public RoleDto updateRole(RoleDto roleDto, int id) {
        return null;
    }

    @Override
    public void roleDelete(int id) {

    }
}
