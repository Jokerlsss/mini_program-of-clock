package com.clock.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.clock.demo.pojo.ClockRecord;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created with IntelliJ IDEA.
 * User: 刘铄
 * Date: 2019/12/24
 * Time: 21:59
 * Description:
 */
@Mapper
public interface ClockRecordMapper extends BaseMapper<ClockRecord> {
}
