package com.clock.demo.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.clock.demo.mapper.UserMapper;
import com.clock.demo.pojo.User;
import com.clock.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: 刘铄
 * Date: 2019/12/24
 * Time: 22:56
 * Description:
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> list() {
        return null;
    }

    @Override
    public int insert(User bean) {
        return 0;
    }

    @Override
    public int delete(Long id) {
        return 0;
    }

    @Override
    public int update(User bean) {
        return 0;
    }

    @Override
    public User load(Long id) {
        return null;
    }

    @Override
    public Integer count() {
        return null;
    }

    @Override
    public IPage<User> pager(Long pageNum, Long pageSize) {
        return null;
    }

    @Override
    public User loadByName(String name) {
        System.out.println("userServiceImpl:"+userMapper.selectByName(name));
        return userMapper.selectByName(name);
    }

    @Override
    public IPage<User> pagerByName(Wrapper<User> wrapper, Long pageNum, Long pageSize) {
        return null;
    }
}
