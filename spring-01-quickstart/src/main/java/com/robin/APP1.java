package com.robin;

import com.robin.service.BookService;
import com.robin.service.impl.BookServiceImpl;

public class APP1 {
    public static void main(String[] args) {
        BookService bookService = new BookServiceImpl();
        bookService.save();
    }
}
