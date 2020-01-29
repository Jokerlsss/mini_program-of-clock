package com.clock.demo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.sun.xml.internal.ws.api.FeatureListValidatorAnnotation;
import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * User: 刘铄
 * Date: 2020/1/3
 * Time: 16:29
 * Description: 活动表
 */
@TableName("activity")
@Data
public class Activity {
    public Activity(){}

    @TableId(value = "actid",type = IdType.AUTO)
    private Long actid;

    @TableField(value = "actname")
    private String actname;

    @TableField(value = "actday")
    private String actday;

    @TableField(value = "userid")
    private Long userid;

    /**
     * flag 为 0 ：未完成
     * 为 1 ：已完成
     */
    @TableField(value = "flag")
    private Long flag;

    /**
     * 已完成的天数，默认为 0
     */
    @TableField(value = "finishday")
    private int finishday;

    /**
     * 今日是否打卡，默认为 0 未打卡，1 为已打卡 ，过凌晨12点后状态更改为 0
     */
    @TableField(value = "istoday")
    private int istoday;

    /**
     * 活动类型：学习、运动、音乐、水果、娱乐
     */
    @TableField(value = "type")
    private String type;

}
