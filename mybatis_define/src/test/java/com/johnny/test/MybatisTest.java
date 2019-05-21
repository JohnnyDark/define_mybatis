package com.johnny.test;

import com.johnny.dao.IUserDao;
import com.johnny.domain.User;
import com.johnny.mybatis.io.Resources;
import com.johnny.mybatis.sqlsession.SqlSession;
import com.johnny.mybatis.sqlsession.SqlSessionFactory;
import com.johnny.mybatis.sqlsession.SqlSessionFactoryBuilder;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {
    public static void main(String[] args) throws IOException {
        //读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //使用工厂产生SqlSession对象
        SqlSession session = factory.openSession();
        //使用sqlsession对象创建dao代理对象
        IUserDao dao = session.getMapper(IUserDao.class);
        //使用代理对象执行方法，查询数据库
        List<User> users=dao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
        //释放资源
        session.close();
        in.close();
//        //1.读取配置文件
//        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
//        //2.创建SqlSessionFactory工厂
//        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
//        SqlSessionFactory factory = builder.build(in);
//        //3.使用工厂生产SqlSession对象
//        SqlSession session = factory.openSession();
//        //4.使用SqlSession创建Dao接口的代理对象
//        IUserDao dao = session.getMapper(IUserDao.class);
//        //5.使用代理对象执行方法
//        List<User> users = dao.findAll();
//        for(User user : users){
//            System.out.println(user);
//        }
//        //6.释放资源
//        session.close();
//        in.close();
    }
}
