package com.robin.factory;

import com.robin.dao.UserDao;
import com.robin.dao.impl.UserDaoImpl;
import org.springframework.beans.factory.FactoryBean;

public class UserDaoFactoryBean implements FactoryBean<UserDao> {
    @Override
    public UserDao getObject() throws Exception {
        return new UserDaoImpl();
    }

    @Override
    public Class<?> getObjectType() {
        return UserDao.class;
    }
    // 单例？
    @Override
    public boolean isSingleton() {
        return false;
    }
}
