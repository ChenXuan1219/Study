package com.ssm;

import com.ssm.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Main {


    
    public static SqlSession sqlSession(String resource) throws Exception{

        InputStream is = Resources.getResourceAsStream(resource);

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

        return sqlSessionFactory.openSession();
        
    }

    

    @Test
    public void test_selectList() throws Exception{
        List<User> users = sqlSession("mybatis-config.xml").selectList("selectUser");

        for (User user:users){
            System.out.println(user);
        }
    }

    @Test
    public void test_insert() throws Exception{

        SqlSession sqlSession = sqlSession("mybatis-config.xml");
        System.out.println(
                sqlSession
                        .insert(
                                "insertUser",
                                new User(4,"cxx","26")
                        )
        );

        sqlSession.commit();
        sqlSession.rollback();

        sqlSession.close();

    }


    


}