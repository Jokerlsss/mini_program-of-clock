package com.clock.demo.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.clock.demo.pojo.Activity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: 刘铄
 * Date: 2020/1/3
 * Time: 16:33
 * Description:
 */
@Service
public interface ActicityService extends BaseService<Activity>{
    /**
     * 根据查询条件返回活动列表
     * @param wrapper
     * @return
     */
    public List<Activity> listByWrapper(Wrapper<Activity> wrapper);

    public int updateByWrapper(Activity entity, Wrapper<Activity> updateWrapper);

    public int updateIsToday(int istoday);
}
