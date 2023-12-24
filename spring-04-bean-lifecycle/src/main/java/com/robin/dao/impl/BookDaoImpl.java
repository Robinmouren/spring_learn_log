package com.robin.dao.impl;

import com.robin.dao.BookDao;

public class BookDaoImpl implements BookDao {
    @Override
    public void save() {
        System.out.println("bookDao impl save...");
    }

    public void init(){
        System.out.println("init ...");
    }

    public void destroy(){
        System.out.println("destroy ...");
    }
}
