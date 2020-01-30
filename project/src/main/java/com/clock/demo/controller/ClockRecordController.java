package com.clock.demo.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.clock.demo.pojo.Activity;
import com.clock.demo.pojo.ClockRecord;
import com.clock.demo.service.ActicityService;
import com.clock.demo.service.ClockRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: 刘铄
 * Date: 2019/12/24
 * Time: 22:05
 * Description:
 */
@RestController
@RequestMapping(path={"/record"})
public class ClockRecordController implements BaseController<ClockRecord>{
    @Autowired
    ClockRecordService clockRecordService;

    @Autowired
    ActicityService acticityService;

    /**
     * 返回所有打卡记录信息
     * @return clockRecordService.list();
     */
    @Override
    @GetMapping("/list")
    public List<ClockRecord> list() {
        return clockRecordService.list();
    }

    /**
     * 根据id查询对应的打卡记录
     * @param userid
     * @return clockRecordService.listByWrapper(queryWrapper)
     */
    @GetMapping("/listById")
    public List<ClockRecord> listById(@RequestParam(value="userid",required = false) Long userid,@RequestParam(value="actid",required = false) Long actid){
        QueryWrapper<ClockRecord> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userid",userid);
//        System.out.println("actid:"+actid);
        queryWrapper.eq("actid",actid);
        return clockRecordService.listByWrapper(queryWrapper);
    }


    /**
     * 打卡
     * @param bean
     * @return
     */
    @Override
    @PostMapping("/insert")
    public int insert(@RequestBody(required = false) ClockRecord bean) {
        /**
         * 通过用户 id 和活动 id ，对活动中的完成天数作更新操作
         */
        Long userid=bean.getUserid();
        Long actid=bean.getActid();
//        QueryWrapper<Activity> queryWrapper=new QueryWrapper<>();
//        queryWrapper.eq("userid",userid);
//        queryWrapper.eq("actid",actid);
        /**
         * 参数： actid
         * 先查出当前完成天数，再局部更新活动的完成天数
         * flag : 1 为 添加打卡记录成功，返回值为 1
                */
        int flag=clockRecordService.insert(bean);
        if(flag==1){
            int finishday=acticityService.load(actid).getFinishday();
            Activity activity=new Activity();
            activity.setFinishday(finishday+1);
            activity.setActid(actid);
            activity.setIstoday(1);
            acticityService.update(activity);
        }
        return flag;
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
