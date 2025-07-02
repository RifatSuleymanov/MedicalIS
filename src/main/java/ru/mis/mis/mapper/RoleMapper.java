package ru.mis.mis.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.mis.mis.dto.RoleDto;
import ru.mis.mis.model.Role;

@Mapper
public interface RoleMapper {
    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);

    RoleDto toRoleDto(Role role);
    Role toRole(RoleDto roleDto);
}
