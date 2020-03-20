package com.clock.demo.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.clock.demo.pojo.StockIn;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: 刘铄
 * Date: 2020/3/20
 * Time: 15:16
 * Description:
 */
@Service
public interface StockInService extends BaseService<StockIn>{
    public IPage<StockIn> selectPage(IPage<StockIn> ipage, Wrapper<StockIn> wrapper);
}
