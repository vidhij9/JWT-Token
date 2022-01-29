package io.gatearrays.userservice.Repository;

import io.gatearrays.userservice.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
