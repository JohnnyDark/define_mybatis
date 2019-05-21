package com.johnny.mybatis.sqlsession;

import com.johnny.mybatis.cfg.Configuration;
import com.johnny.mybatis.sqlsession.defaults.DefaultSqlSessionFactory;
import com.johnny.mybatis.utils.XMLConfigBuilder;

import java.io.InputStream;

/**
 * 创建一个SqlSessionFactoryBuilder对象
 */
public class SqlSessionFactoryBuilder {
    /**
     * 根据字节输入流参数构建一个SqlSessionFactory工厂
     * @param config
     * @return
     */
    public SqlSessionFactory build(InputStream config) {
        Configuration cfg = XMLConfigBuilder.loadConfiguration(config);
        return new DefaultSqlSessionFactory(cfg);
    }
}
