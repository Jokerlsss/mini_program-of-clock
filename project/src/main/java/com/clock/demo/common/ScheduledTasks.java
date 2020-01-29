package com.clock.demo.common;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.clock.demo.pojo.Activity;
import com.clock.demo.service.ActicityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;

/**
 * 定时器
 */

@Component
@EnableScheduling
public class ScheduledTasks {

    @Autowired
    private ActicityService acticityService;

    /**
     * 当过了凌晨时，活动状态更改为 ：未打卡
     */
    //秒-分-时
    @Scheduled(cron = "0 2 19 * * ?")
    public void BookOrderTask() {
        QueryWrapper<Activity> queryWrapper=new QueryWrapper<>();
        Date date=new Date();
        java.sql.Date sqlDate=new java.sql.Date(date.getTime());

        //ne：数据不能为val
//        queryWrapper.eq("istoday",1);
//        queryWrapper.ne("bookstate",5);
//        queryWrapper.ne("bookstate",6);
//        Activity activity=new Activity();
//        System.out.println("activity.finishday:"+activity.getFinishday());
        //更改状态为未打卡：0

//        activity.setIstoday(0);
        /**
         * istoday: 1 为已打卡，0 为未打卡
         */
        int i=acticityService.updateIsToday(1);

        System.out.println("i:"+i);
        System.out.println("定时器更新成功！");
    }
}
