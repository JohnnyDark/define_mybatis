package com.johnny.mybatis.sqlsession.defaults;

import com.johnny.dao.IUserDao;
import com.johnny.mybatis.cfg.Configuration;
import com.johnny.mybatis.sqlsession.SqlSession;
import com.johnny.mybatis.sqlsession.proxy.MapperProxy;
import com.johnny.mybatis.utils.DataSourceUtil;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * SqlSession接口的实现类
 */
public class DefaultSqlSession implements SqlSession {

    private Configuration cfg;
    private Connection connection;

    public DefaultSqlSession(Configuration cfg) {
        this.cfg = cfg;
        connection = DataSourceUtil.getConnection(cfg);
    }

    /**
     * 创建代理对象
     * @param daoInterfaceClass dao的接口字节码
     * @param <T>
     * @return
     */
    public <T> T getMapper(Class<T> daoInterfaceClass) {
        return (T) Proxy.newProxyInstance(daoInterfaceClass.getClassLoader(), new Class[]{daoInterfaceClass}, new MapperProxy(cfg.getMappers(), connection));
    }

    /**
     * 释放资源
     */
    public void close() {
        if (connection!=null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
