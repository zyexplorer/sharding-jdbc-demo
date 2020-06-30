package com.zy.shardingjdbcdemo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zy.shardingjdbcdemo.dao.BookMapper;
import com.zy.shardingjdbcdemo.entity.Book;
import com.zy.shardingjdbcdemo.service.BookService;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Macky
 * @Title class BookServiceImpl
 * @Description: TODO
 * @date 2019/7/12 20:47
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements BookService {

    @Override
    public List<Book> getBookList() {
        return baseMapper.selectList(Wrappers.lambdaQuery());
    }

    @Override
    public boolean save(Book book) {
        return super.save(book);
    }
}
