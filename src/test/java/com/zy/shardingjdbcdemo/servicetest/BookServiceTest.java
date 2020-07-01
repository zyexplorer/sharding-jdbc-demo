package com.zy.shardingjdbcdemo.servicetest;

import com.zy.shardingjdbcdemo.ShardingJdbcDemoApplicationTests;
import com.zy.shardingjdbcdemo.entity.Book;
import com.zy.shardingjdbcdemo.service.BookService;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;

public class BookServiceTest extends ShardingJdbcDemoApplicationTests {

    @Resource
    BookService bookService;

    @Test
    public void testSaveBook() {
        long s = System.currentTimeMillis();
        for (int i = 1; i <= 500000; i++) {
            Book book = Book.builder().id(i).count(i).name("西游记" + i).build();
            bookService.save(book);
        }
        long e = System.currentTimeMillis();
        System.out.println("插入500000数据耗时：" + (e - s) + "ms");
    }

}
