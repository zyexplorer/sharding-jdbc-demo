package com.zy.shardingjdbcdemo.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import com.zy.shardingjdbcdemo.dao.BookMapper;
import com.zy.shardingjdbcdemo.entity.Book;
import com.zy.shardingjdbcdemo.service.BookService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author Macky
 * @Title class BookServiceImpl
 * @Description: TODO
 * @date 2019/7/12 20:47
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements BookService {

    @Resource
    BookMapper bookMapper;

    @Override
    public List<Book> getBookList(Integer page, Integer pageSize) {
        List<Book> retList = Lists.newArrayList();
        QueryWrapper<Book> wrapper = new QueryWrapper<>();
        Page<Book> p = new Page<>(page, pageSize);
        // 排序字段
        // wrapper.orderByAsc("id");
        IPage<Map<String, Object>> mapsPage = bookMapper.selectMapsPage(p, wrapper);
        if (mapsPage != null) {
            List<Map<String, Object>> records = mapsPage.getRecords();
            if (!CollectionUtils.isEmpty(records)) {
                // map转实体类(map中的对象字段必须与实体类的属性字段相同)
                //records.forEach(map -> retList.add(Book.builder().id((Integer) map.get("id")).count((Integer) map.get("count")).name((String) map.get("name")).build()));
                records.forEach(map -> retList.add(JSON.parseObject(JSON.toJSONString(map), Book.class)));
            }
        }
        return retList;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean save(Book book) {
        return super.save(book);
    }

    @Override
    public Integer getMaxId() {
        return bookMapper.queryMaxId();
    }
}
