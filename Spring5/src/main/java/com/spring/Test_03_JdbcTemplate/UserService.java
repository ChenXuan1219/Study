package com.spring.Test_03_JdbcTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "UserService")
public class UserService {

    @Autowired
    private UserDao userDao;

    public void select(){
    }

}
