package com.zy.shardingjdbcdemo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zy.shardingjdbcdemo.entity.Book;
import org.springframework.stereotype.Repository;

/**
 * @author ZY
 */
@Repository
public interface BookMapper extends BaseMapper<Book> {

}
