package com.clock.demo.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.clock.demo.pojo.StockIn;
import com.clock.demo.service.StockInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: 刘铄
 * Date: 2020/3/20
 * Time: 15:16
 * Description:
 */
@RestController
@RequestMapping(path={"/StockIn"})
public class StockInController implements BaseController<StockIn> {

    @Autowired
    StockInService stockInService;

    @Override
    public List<StockIn> list() {
        return null;
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
        return null;
    }

    @GetMapping("/page")
    @Override
    public IPage<StockIn> pager(@RequestParam(value = "current", required=false ) Long current,
                                @RequestParam(value = "size", required=false ) Long size) {
        Integer total=stockInService.count();
        IPage<StockIn> pages=new Page<>(current,size,total);
        pages=stockInService.selectPage(pages,null);
        return pages;
    }

    @Override
    public StockIn loadByName(String name) {
        return null;
    }

    @Override
    public IPage<StockIn> pagerByName(Wrapper<StockIn> wrapper, Long pageNum, Long pageSize) {
        return null;
    }


}
