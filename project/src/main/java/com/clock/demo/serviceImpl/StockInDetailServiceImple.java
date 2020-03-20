package com.clock.demo.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.clock.demo.mapper.StockInDetailMapper;
import com.clock.demo.pojo.StockInDetail;
import com.clock.demo.service.StockInDetailService;
import com.sun.xml.internal.ws.developer.Serialization;
import org.springframework.beans.factory.annotation.Autowired;
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
public class StockInDetailServiceImple implements StockInDetailService {

    @Autowired
    StockInDetailMapper stockInDetailMapper;

    @Override
    public List<StockInDetail> list() {
        return null;
    }

    @Override
    public int insert(StockInDetail bean) {
        return 0;
    }

    @Override
    public int delete(Long id) {
        return 0;
    }

    @Override
    public int update(StockInDetail bean) {
        return 0;
    }

    @Override
    public StockInDetail load(Long id) {
        return null;
    }

    @Override
    public Integer count() {
        return null;
    }

    @Override
    public IPage<StockInDetail> pager(Long pageNum, Long pageSize) {
        return null;
    }

    @Override
    public StockInDetail loadByName(String name) {
        return null;
    }

    @Override
    public IPage<StockInDetail> pagerByName(Wrapper<StockInDetail> wrapper, Long pageNum, Long pageSize) {
        return null;
    }
}
