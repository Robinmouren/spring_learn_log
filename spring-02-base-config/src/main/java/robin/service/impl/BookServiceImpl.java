package robin.service.impl;


import robin.dao.BookDao;
import robin.service.BookService;

public class BookServiceImpl implements BookService {

    BookDao bookDao;

    public void save() {
        System.out.println("bookService impl save...");
    }

    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }
}
