package com.johnny.dao;

import com.johnny.domain.User;


import java.util.List;

public interface IUserDao {

    List<User> findAll();
}
