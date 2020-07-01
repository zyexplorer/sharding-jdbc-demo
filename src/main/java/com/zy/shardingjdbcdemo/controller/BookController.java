package com.zy.shardingjdbcdemo.controller;


import com.zy.shardingjdbcdemo.entity.Book;
import com.zy.shardingjdbcdemo.service.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Macky
 * @Title class BookController
 * @Description:
 */
@RestController
@RequestMapping("/book")
public class BookController {

    @Resource
    BookService bookService;

    @GetMapping("/getBookList")
    public List<Book> getItems(){
        return bookService.getBookList();
    }

    @PostMapping("/saveBook")
    public Boolean saveBook(Book book){
        return bookService.save(book);
    }
}
