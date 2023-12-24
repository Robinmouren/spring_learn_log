package com.robin;

import com.robin.dao.UserDao;
import com.robin.dao.impl.UserDaoImpl;
import com.robin.factory.UserDaoFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppUser {
    public static void main(String[] args) {

        /*UserDaoFactory userDaoFactory = new UserDaoFactory();
        UserDao userDao = userDaoFactory.getUserDao();
        userDao.save();*/

        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao1 = (UserDao) ctx.getBean("userDao");
        UserDao userDao2 = (UserDao) ctx.getBean("userDao");
        userDao1.save();
        System.out.println(userDao1);
        System.out.println(userDao2);


    }
}
