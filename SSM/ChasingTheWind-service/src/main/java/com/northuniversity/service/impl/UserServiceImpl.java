package com.northuniversity.service.impl;

import com.northuniversity.mapper.UserMapper;
import com.northuniversity.model.User;
import com.northuniversity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * created by viking on 2018/07/04
 * 业务层接口实现类
 */

@Service
public class UserServiceImpl implements UserService {
    /**
     * Usermapper
     */
    @Autowired
    private UserMapper userMapper;

    public List<User> getUser(int id) {
        Map map = new HashMap();
        map.put("id",id);
        return  userMapper.getUser(map);
    }

    @Override
    public void insertUser(String uName, String uPassword, int uGender, String uNumber, String uAvator) {
        Map param = new HashMap();
        param.put("uName",uName);
        param.put("uPassword",uPassword);
        param.put("uGender",uGender);
        param.put("uNumber",uNumber);
        userMapper.insertUser(param);
    }
    

    public List<User> selectAll() {

        return userMapper.selectAll();
    }

    public Object update() {
        Map param = new HashMap();
        param.put("total",10);
        param.put("name","测试2");
        userMapper.update(param);
        return "OK";
    }

    @Override
    public User getUserByNumber(String uNumber) {
        return null;
    }

    public User getUserByName(String uname) {
        return userMapper.getUserByName(uname);
    }

    public void updateBid(User user) {
        userMapper.updateBid(user);
    }

}
