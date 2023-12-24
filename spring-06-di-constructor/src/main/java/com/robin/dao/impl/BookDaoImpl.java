package com.robin.dao.impl;

import com.robin.dao.BookDao;

public class BookDaoImpl implements BookDao {

    private int count;
    private String name;

    public BookDaoImpl(int count, String name) {
        this.count = count;
        this.name = name;
    }

    @Override
    public void save() {
        System.out.println("book dao save..." + "," + count + "," + name);
    }
}
