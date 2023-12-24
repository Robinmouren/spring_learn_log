package com.robin.dao.impl;

import com.robin.dao.BookDao;

public class BookDaoImpl implements BookDao {

    private int count;
    private String name;

    public void setCount(int count) {
        this.count = count;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void save() {
        System.out.println("bookDao impl save..." + "," + count + "," + name);
    }

}
