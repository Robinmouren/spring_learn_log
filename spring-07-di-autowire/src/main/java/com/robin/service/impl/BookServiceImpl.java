package com.robin.service.impl;

import com.robin.dao.BookDao;
import com.robin.service.BookService;

public class BookServiceImpl implements BookService {

    BookDao bookDao;

    @Override
    public void save() {
        System.out.println("book service save...");
        bookDao.save();
    }

    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }
}
