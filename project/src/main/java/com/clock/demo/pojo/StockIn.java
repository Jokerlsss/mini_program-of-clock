package com.clock.demo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: 刘铄
 * Date: 2020/3/20
 * Time: 15:08
 * Description: 仓库管理分页测试用
 */
@TableName("stockin")
@Data
public class StockIn {
    public StockIn(){}

    @TableId(value = "stockInNum")
    private String stockInNum;

    @TableField(value = "stockInDate")
    private Date stockInDate;

    @TableField(value = "remark")
    private String remark;
}
