package io.gatearrays.userservice;

import io.gatearrays.userservice.Model.Role;
import io.gatearrays.userservice.Model.User;
import io.gatearrays.userservice.Service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class UserserviceApplication {

  public static void main(String[] args) {
    SpringApplication.run(UserserviceApplication.class, args);
  }

  @Bean
  PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  CommandLineRunner run(UserService userService) {
    return args -> {
      userService.saveRole(new Role(null, "USER"));
      userService.saveRole(new Role(null, "MANAGER"));
      userService.saveRole(new Role(null, "ADMIN"));
      userService.saveRole(new Role(null, "SUPER_ADMIN"));

      userService.saveUser(new User(null, "Bob Warren", "bob", "1234", new ArrayList<>()));
      userService.saveUser(new User(null, "Cassian Hall", "cass", "1234", new ArrayList<>()));
      userService.saveUser(new User(null, "Prudence Gray", "gray", "1234", new ArrayList<>()));
      userService.saveUser(new User(null, "Rusty Silva", "rust", "1234", new ArrayList<>()));

      userService.addRoleToUser("bob", "USER");
      userService.addRoleToUser("bob", "MANAGER");
      userService.addRoleToUser("cass", "MANAGER");
      userService.addRoleToUser("gray", "ADMIN");
      userService.addRoleToUser("rust", "SUPER_ADMIN");
      userService.addRoleToUser("rust", "ADMIN");
      userService.addRoleToUser("rust", "USER");
    };
  }
}
