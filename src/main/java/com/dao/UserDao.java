package com.dao;

import com.modules.User;

public interface UserDao {
    User getUser(String username, String password);
}
