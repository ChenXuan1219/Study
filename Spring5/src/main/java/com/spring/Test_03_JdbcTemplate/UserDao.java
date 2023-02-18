package com.spring.Test_03_JdbcTemplate;

import jdk.nashorn.internal.ir.CallNode;
import org.springframework.jdbc.core.JdbcTemplate;

public interface UserDao {

    public Object selectUser();

    public String addUser(User user);

    public int updateUser(User user);

    public int deleteUser(int id);


}
