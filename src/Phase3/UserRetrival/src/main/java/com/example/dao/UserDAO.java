package com.example.dao;

import com.example.User;

public interface UserDAO {
    User getUserById(int id);
    void updateUser(User user);
}
