package com.robin.dao.impl;

import com.robin.dao.UserDao;

public class UserDaoImpl implements UserDao {
    @Override
    public void save() {
        System.out.println("userDao Impl save...");
    }
}
