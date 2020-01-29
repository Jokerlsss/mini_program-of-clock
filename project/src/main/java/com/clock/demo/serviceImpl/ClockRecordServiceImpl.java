package com.clock.demo.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.clock.demo.mapper.ClockRecordMapper;
import com.clock.demo.pojo.ClockRecord;
import com.clock.demo.service.ClockRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: 刘铄
 * Date: 2019/12/24
 * Time: 22:03
 * Description:
 */
@Service
public class ClockRecordServiceImpl implements ClockRecordService {
    @Autowired
    private ClockRecordMapper clockRecordMapper;

    @Override
    public List<ClockRecord> list() {
        return clockRecordMapper.selectList(null);
    }

    /**
     * 根据条件查询“打卡记录”列表
     * @param wrapper
     * @return
     */
    public List<ClockRecord> listByWrapper(Wrapper<ClockRecord> wrapper) {
        return clockRecordMapper.selectList(wrapper);
    }


    @Override
    public int insert(ClockRecord bean) {
        return clockRecordMapper.insert(bean);
    }

    @Override
    public int delete(Long id) {
        return 0;
    }

    @Override
    public int update(ClockRecord bean) {
        return 0;
    }

    @Override
    public ClockRecord load(Long id) {
        return null;
    }

    @Override
    public Integer count() {
        return null;
    }

    @Override
    public IPage<ClockRecord> pager(Long pageNum, Long pageSize) {
        return null;
    }

    @Override
    public ClockRecord loadByName(String name) {
        return null;
    }

    @Override
    public IPage<ClockRecord> pagerByName(Wrapper<ClockRecord> wrapper, Long pageNum, Long pageSize) {
        return null;
    }
}
