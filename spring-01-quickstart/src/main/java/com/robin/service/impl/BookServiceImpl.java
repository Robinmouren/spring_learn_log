package com.robin.service.impl;

import com.robin.dao.BookDao;
import com.robin.dao.impl.BookDaoImpl;
import com.robin.service.BookService;


public class BookServiceImpl implements BookService {

    private BookDao bookDao;

    public void save() {
        System.out.println("BookService impl save...");
        bookDao.save();
    }

    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }
}
