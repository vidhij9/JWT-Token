package io.gatearrays.userservice.Repository;

import io.gatearrays.userservice.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
