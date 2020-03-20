package com.clock.demo.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: 刘铄
 * Date: 2020/3/20
 * Time: 15:11
 * Description: 仓库管理分页测试用
 */
@TableName("stockindetail")
@Data
public class StockInDetail {
    public StockInDetail(){}

    @TableField(value = "stockInNum")
    private String stockInNum;

    @TableField(value = "productSize")
    private String productSize;

    @TableField(value = "productName")
    private String productName;

    @TableField(value = "amount")
    private int amount;
}
