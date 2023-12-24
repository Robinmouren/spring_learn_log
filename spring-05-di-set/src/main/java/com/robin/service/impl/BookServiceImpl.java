package com.robin.service.impl;

import com.robin.dao.BookDao;
import com.robin.dao.UserDao;
import com.robin.service.BookService;

public class BookServiceImpl implements BookService {

    private BookDao bookDao;
    private UserDao userDao;


    @Override
    public void save() {
        System.out.println("bookService impl save...");
        bookDao.save();
        userDao.save();
    }

    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
