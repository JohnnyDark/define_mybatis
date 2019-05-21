package com.johnny.mybatis.utils;

import com.johnny.mybatis.cfg.Configuration;
import com.johnny.mybatis.io.Resources;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSourceUtil {
    /**
     * 获取一个连接
     * @param cfg
     * @return
     */
    public static Connection getConnection(Configuration cfg) {
        try {
            Connection connection = DriverManager.getConnection(cfg.getUrl(), cfg.getUsername(), cfg.getPassword());
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        System.out.println(getConnection(XMLConfigBuilder.loadConfiguration(Resources.getResourceAsStream("SqlMapConfig.xml"))));
    }
}
