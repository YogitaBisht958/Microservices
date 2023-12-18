package com.cfg.user.service.services;

import com.cfg.user.service.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface userService {
    User saveUser(User user);

    List<User> getAllUser();

    User getUser(String userId);
}
