package com.clock.demo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * User: 刘铄
 * Date: 2019/12/24
 * Time: 21:47
 * Description: 打卡记录
 */
@TableName("clockRecord")
@Data
public class ClockRecord {
    public ClockRecord(){}

    @TableId(value = "userid",type = IdType.INPUT)
    private Long userid;

    @TableId(value = "clockdate",type = IdType.INPUT)
    private String clockdate;

    @TableId(value = "actid",type = IdType.INPUT)
    private Long actid;
}
