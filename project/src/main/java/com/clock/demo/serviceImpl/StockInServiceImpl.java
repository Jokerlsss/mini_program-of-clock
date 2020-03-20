package com.clock.demo.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.clock.demo.mapper.StockInMapper;
import com.clock.demo.pojo.StockIn;
import com.clock.demo.service.StockInService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: 刘铄
 * Date: 2020/3/20
 * Time: 15:16
 * Description:
 */
@Service
public class StockInServiceImpl implements StockInService {

    @Autowired
    StockInMapper stockInMapper;

    @Override
    public List<StockIn> list() {
        return stockInMapper.selectList(null);
    }

    @Override
    public int insert(StockIn bean) {
        return 0;
    }

    @Override
    public int delete(Long id) {
        return 0;
    }

    @Override
    public int update(StockIn bean) {
        return 0;
    }

    @Override
    public StockIn load(Long id) {
        return null;
    }

    @Override
    public Integer count() {
        return stockInMapper.selectCount(null);
    }

    @Override
    public IPage<StockIn> pager(Long pageNum, Long pageSize) {
        Page<StockIn> page=new Page<>(pageNum,pageSize);
        return stockInMapper.selectPage(page,null);
    }

    @Override
    public StockIn loadByName(String name) {
        return null;
    }

    @Override
    public IPage<StockIn> pagerByName(Wrapper<StockIn> wrapper, Long pageNum, Long pageSize) {
        return null;
    }

    @Override
    public IPage<StockIn> selectPage(IPage<StockIn> ipage, Wrapper<StockIn> wrapper) {
        return stockInMapper.selectPage(ipage,wrapper);
    }
}
