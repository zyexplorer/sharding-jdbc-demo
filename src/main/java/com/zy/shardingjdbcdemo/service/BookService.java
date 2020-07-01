package com.zy.shardingjdbcdemo.service;

import com.zy.shardingjdbcdemo.entity.Book;

import java.util.List;

/**
 * @author ZY
 */
public interface BookService {

    /**
     * 返回书籍列表
     * @param page 页码
     * @param pageSize 每页条数
     * @return 书籍列表
     */
    List<Book> getBookList(Integer page, Integer pageSize);

    /**
     * 保存书籍实体
     * @param book 实体
     * @return 成功或失败
     */
    boolean save(Book book);

    /**
     * 获取book表的最大ID
     * @return 返回book表的最大ID
     */
    Integer getMaxId();
}
