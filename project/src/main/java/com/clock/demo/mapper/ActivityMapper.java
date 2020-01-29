package com.clock.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.clock.demo.controller.BaseController;
import com.clock.demo.pojo.Activity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

/**
 * Created with IntelliJ IDEA.
 * User: 刘铄
 * Date: 2020/1/3
 * Time: 16:39
 * Description:
 */
@Mapper
public interface ActivityMapper extends BaseMapper<Activity> {
    @Update("update activity set istoday=0 where istoday=#{istoday}")
    public int updateIsToday(int istoday);
}
