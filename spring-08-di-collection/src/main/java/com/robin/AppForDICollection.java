package com.robin;

import com.robin.dao.BookDao;
import com.robin.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppForDICollection {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookDao bookDao = ctx.getBean(BookDao.class);
        bookDao.save();
    }
}
