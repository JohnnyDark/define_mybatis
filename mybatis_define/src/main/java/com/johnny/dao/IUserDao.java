package com.johnny.dao;

import com.johnny.domain.User;
import com.johnny.mybatis.annotations.Select;


import java.util.List;

public interface IUserDao {
    @Select("select * from user")
    List<User> findAll();
}
