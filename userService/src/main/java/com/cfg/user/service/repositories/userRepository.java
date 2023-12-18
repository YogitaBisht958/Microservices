package com.cfg.user.service.repositories;

import com.cfg.user.service.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepository extends JpaRepository<User, String> {
}
