package com.robin.dao.impl;

import com.robin.dao.OrderDao;

public class OrderDaoImpl implements OrderDao {

    @Override
    public void save() {
        System.out.println("orderDao Impl save...");
    }
}
