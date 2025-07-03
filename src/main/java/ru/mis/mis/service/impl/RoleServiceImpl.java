package ru.mis.mis.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.mis.mis.dto.RoleDto;
import ru.mis.mis.exception.ModelNotFoundException;
import ru.mis.mis.mapper.RoleMapper;
import ru.mis.mis.model.Role;
import ru.mis.mis.repository.RoleRepository;
import ru.mis.mis.service.RoleService;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    public Optional<Object> gatAll() {
        List<Role> role = roleRepository.findAll();
        if(role.isEmpty()) {
            log.info("No roles found");
            return Optional.empty();
        }
        return Optional.of(role);
    }

    @Override
    public Optional<Role> findById(int id) {
        return Optional.ofNullable(roleRepository.findById(id)
                .orElseThrow(() -> new ModelNotFoundException("Role with id " + id + " not found")));
    }

    @Override
    public RoleDto create(RoleDto roleDto) {
        Role role = RoleMapper.INSTANCE.toRole(roleDto);
        return RoleMapper.INSTANCE.toRoleDto(roleRepository.save(role));
    }

    @Override
    public RoleDto updateRole(RoleDto roleDto, int id) {
        Role roleOriginal = roleRepository.findById(id)
                .orElseThrow(() -> new ModelNotFoundException("Role with id " + id + " not found"));
        Role role = RoleMapper.INSTANCE.toRole(roleDto);
        Optional.ofNullable(role.getName()).ifPresent(roleOriginal::setName);
        Optional.ofNullable(role.getDescription()).ifPresent(roleOriginal::setDescription);

        return RoleMapper.INSTANCE.toRoleDto(roleRepository.save(roleOriginal));
    }

    @Override
    public void roleDelete(int id) {
        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new ModelNotFoundException("Role with id " + id + " not found"));
        roleRepository.delete(role);
    }
}
