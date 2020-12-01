package org.example.service;

import org.example.pojo.User;

public interface UserService {
    User selectUserById(Integer userId);
}
