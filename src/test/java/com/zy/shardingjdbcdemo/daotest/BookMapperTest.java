package com.zy.shardingjdbcdemo.daotest;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zy.shardingjdbcdemo.ShardingJdbcDemoApplicationTests;
import com.zy.shardingjdbcdemo.dao.BookMapper;
import com.zy.shardingjdbcdemo.entity.Book;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;
import java.util.Map;

public class BookMapperTest extends ShardingJdbcDemoApplicationTests {

    @Resource
    BookMapper bookMapper;

    @Test
    public void testSelectMapPage() {
        QueryWrapper<Book> wrapper = new QueryWrapper<>();
        // 设置条件
        //wrapper.gt("id", 0);

        Page<Book> page = new Page<>(1, 2);

        IPage<Map<String, Object>> pageMap = bookMapper.selectMapsPage(page, wrapper);
        System.out.println("总记录数：" + pageMap.getTotal());
        System.out.println("总页数：" + pageMap.getPages());

    }

    @Test
    public void testMyGetTotalCount() {
        int totalCount = bookMapper.getTotalCount();
        System.out.println("自定义SQL查询总记录数：" + totalCount);
    }
}
