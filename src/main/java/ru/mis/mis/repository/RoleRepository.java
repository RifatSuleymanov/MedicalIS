package ru.mis.mis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mis.mis.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
