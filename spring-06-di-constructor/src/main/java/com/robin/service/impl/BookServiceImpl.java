package com.robin.service.impl;

import com.robin.dao.BookDao;
import com.robin.dao.UserDao;
import com.robin.service.BookService;

public class BookServiceImpl implements BookService {

    private BookDao bookDao;
    private UserDao userDao;

    public BookServiceImpl(BookDao bookDao, UserDao userDao) {
        this.bookDao = bookDao;
        this.userDao = userDao;
    }

    @Override
    public void save() {
        System.out.println("book service save...");
        bookDao.save();
        userDao.save();
    }

}
