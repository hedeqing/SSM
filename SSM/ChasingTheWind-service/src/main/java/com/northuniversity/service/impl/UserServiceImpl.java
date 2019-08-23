package com.northuniversity.service.impl;

import com.northuniversity.model.User;
import com.northuniversity.service.UserService;
import com.northuniversity.service.base.IBaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl extends IBaseServiceImpl<User> implements UserService {
//    /**
//     * Usermapper
//     */
//    @Autowired
//    private UserMapper userMapper;

    public List<User> getUser(int id) {
        Map map = new HashMap();
        map.put("id",id);
        return  userMapper.getUser(map);
    }

    @Override
    public void insertUser(String uName, String uPassword, int uGender, String uNumber, String uAvator) {
        Map param = new HashMap();
        param.put("userName",uName);
        param.put("password",uPassword);
        param.put("gender",uGender);
        param.put("number",uNumber);
        userMapper.insertUser(param);
    }

    @Override
    public List<User> selectAllUser() {
        return userMapper.selectAllUser();
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
    @Override
    public Object update(Object o) {
        return null;
    }

    @Override
    public Object insert(Object o) {
        return null;
    }
}
