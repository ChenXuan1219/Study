package com.spring.Test_03_JdbcTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("UserDaoImpl")
public class UserDaoImpl implements UserDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<User> selectUser() {
        return this.jdbcTemplate.query("select * from User", new BeanPropertyRowMapper<User>(User.class));
    }

    @Override
    public String addUser(User user) {

        int update = this.jdbcTemplate.update(
                "insert into User values(?,?,?) ",
                new Object[]{user.getId(), user.getName(), user.getAge()});

        return update >= 1 ? "添加了：" + update + "记录" : "添加失败";
    }

    @Override
    public int updateUser(User user) {

        this.jdbcTemplate.update("update User set name = 'chenxuan' where id  = 1");
        return 0;
    }

    @Override
    public int deleteUser(int id) {
        return 0;
    }
}
