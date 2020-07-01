package com.zy.shardingjdbcdemo.daotest;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zy.shardingjdbcdemo.ShardingJdbcDemoApplicationTests;
import com.zy.shardingjdbcdemo.dao.BookMapper;
import com.zy.shardingjdbcdemo.entity.Book;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

public class BookMapperTest extends ShardingJdbcDemoApplicationTests {

    @Resource
    BookMapper bookMapper;

    @Test
    public void testSelectMapPage() {
        QueryWrapper<Book> wrapper = new QueryWrapper<>();
        // 设置条件
        //wrapper.gt("id", 0);
        wrapper.orderByAsc("id");

        Page<Book> page = new Page<>(2, 10);

        IPage<Map<String, Object>> pageMap = bookMapper.selectMapsPage(page, wrapper);
        System.out.println("总记录数：" + pageMap.getTotal());
        System.out.println("总页数：" + pageMap.getPages());
        List<Map<String, Object>> records = pageMap.getRecords();
        records.forEach(System.out::println);
    }

    @Test
    public void testMyGetTotalCount() {
        int totalCount = bookMapper.getTotalCount();
        System.out.println("自定义SQL查询总记录数：" + totalCount);
    }

    @Test
    public void testGetMaxId() {
        Integer maxId = bookMapper.queryMaxId();
        System.out.println(maxId);
    }
}
