package com.robin;

import com.robin.dao.BookDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        /*BookDao bookDao = ctx.getBean("bookDao",BookDao.class);*/
        /*BookDao bookDao = (BookDao) ctx.getBean("bookBean");*/
        /*BookDao bookDao = ctx.getBean(BookDao.class);
        bookDao.save();*/
    }
}
