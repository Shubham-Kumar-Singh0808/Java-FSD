// src/main/java/com/example/service/UserService.java
package com.example.service;

import com.example.User;

public interface UserService {
    User getUserById(int id);
    void updateUser(User user);
}
