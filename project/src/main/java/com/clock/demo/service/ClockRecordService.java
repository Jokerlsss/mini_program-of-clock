package com.clock.demo.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.clock.demo.pojo.ClockRecord;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: 刘铄
 * Date: 2019/12/24
 * Time: 22:02
 * Description:
 */
@Service
public interface ClockRecordService extends BaseService<ClockRecord>{
    /**
     * 根据条件查询“打卡记录”列表
     * @param wrapper
     * @return
     */
    public List<ClockRecord> listByWrapper(Wrapper<ClockRecord> wrapper);
}
