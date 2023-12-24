package robin.dao.impl;


import robin.dao.BookDao;

public class BookDaoImpl implements BookDao {

    public BookDaoImpl(){
        System.out.println("bookDaoImpl ......");
    }

    public void save() {
        System.out.println("bookDao impl save...");
    }
}
