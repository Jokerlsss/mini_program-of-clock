package com.clock.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.clock.demo.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * Created with IntelliJ IDEA.
 * User: 刘铄
 * Date: 2019/12/24
 * Time: 23:04
 * Description:
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    @Select("select * from user where username=#{name}")
    public User selectByName(String name);
}
