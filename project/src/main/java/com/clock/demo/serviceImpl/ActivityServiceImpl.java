package com.clock.demo.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.clock.demo.mapper.ActivityMapper;
import com.clock.demo.pojo.Activity;
import com.clock.demo.service.ActicityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: 刘铄
 * Date: 2020/1/3
 * Time: 16:34
 * Description:
 */
@Service
public class ActivityServiceImpl implements ActicityService {
    @Autowired
    private ActivityMapper activityMapper;

    @Override
    public List<Activity> list() {
        return null;
    }

    /**
     * 根据 wrapper 查找活动列表
     * @param wrapper
     * @return
     */
    public List<Activity> listByWrapper(Wrapper<Activity> wrapper) {
        return activityMapper.selectList(wrapper);
    }

    @Override
    public int updateByWrapper(Activity entity, Wrapper<Activity> updateWrapper) {
        return activityMapper.update(entity,updateWrapper);
    }

    /**
     * 用定时器更新 “是否打卡”
     * @param istoday
     * @return
     */
    @Override
    public int updateIsToday(int istoday){
        return activityMapper.updateIsToday(istoday);
    }


    @Override
    public int insert(Activity bean) {
        return activityMapper.insert(bean);
    }

    @Override
    public int delete(Long id) {
        return 0;
    }

    @Override
    public int update(Activity bean) {
        return activityMapper.updateById(bean);
    }

    @Override
    public Activity load(Long id) {
        return activityMapper.selectById(id);
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
