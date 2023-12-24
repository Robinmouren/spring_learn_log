package com.robin;

import com.robin.dao.BookDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;

public class APP {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        /*DataSource dataSource = (DataSource) ctx.getBean("dataSource");
        System.out.println(dataSource);*/


        BookDao bookDao = ctx.getBean(BookDao.class);
        bookDao.save();
    }
}
