package com.robin.factory;

import com.robin.dao.OrderDao;
import com.robin.dao.impl.OrderDaoImpl;

public class OrderDaoFactory {
    public static OrderDao getOrderDao(){
        System.out.println("orderDao factory setup...");
        return new OrderDaoImpl();
    }
}
