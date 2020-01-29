package com.clock.demo.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.clock.demo.pojo.Activity;
import com.clock.demo.pojo.ClockRecord;
import com.clock.demo.service.ActicityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: 刘铄
 * Date: 2020/1/3
 * Time: 16:34
 * Description:
 */
@RestController
@RequestMapping(path={"/activity"})
public class ActivityController implements BaseController<Activity>{

    @Autowired
    private ActicityService acticityService;

    @Override
    public List<Activity> list() {
        return null;
    }


    /**
     * 新增活动
     * @param bean
     * @return
     */
    @Override
    @PostMapping("/insert")
    public int insert(@RequestBody(required = false) Activity bean) {
//        Long userid=Long.valueOf(1);
//        bean.setUserid(userid);
//        System.out.println("进入insert...");
        return acticityService.insert(bean);
    }

    /**
     * 查找进行中的活动列表
     * @param userid
     * @return
     */
    @GetMapping("listById")
    public List<Activity> listById(@RequestParam(value="userid",required = false) Long userid,@RequestParam(value="flag",required = false) Long flag){
        QueryWrapper<Activity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userid",userid);
        queryWrapper.eq("flag",flag);
        return acticityService.listByWrapper(queryWrapper);
    }


    @Override
    public int delete(Long id) {
        return 0;
    }

    @Override
    public int update(Activity bean) {
        return 0;
    }

    @Override
    public Activity load(Long id) {
        return null;
    }

    @Override
    public Integer count() {
        return null;
    }

    @Override
    public IPage<Activity> pager(Long pageNum, Long pageSize) {
        return null;
    }

    @Override
    public Activity loadByName(String name) {
        return null;
    }

    @Override
    public IPage<Activity> pagerByName(Wrapper<Activity> wrapper, Long pageNum, Long pageSize) {
        return null;
    }
}
