package com.robin.factory;

import com.robin.dao.UserDao;
import com.robin.dao.impl.UserDaoImpl;

public class UserDaoFactory {
    public UserDao getUserDao(){
        return new UserDaoImpl();
    }
}
