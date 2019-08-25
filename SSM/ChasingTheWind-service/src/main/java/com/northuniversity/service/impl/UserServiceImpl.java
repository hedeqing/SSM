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


    @Override
    public User getUserByNumber(String number) {
        return userMapper.getUserByNumber(number);
    }


    @Override
    public User get(User user) {
        //提前检查

        if(!user.getNumber().equals("") && !user.getPassword().equals("")){
            return userMapper.selectUser(user);
        }
        return null;
    }


    public User getUserByName(String uname) {
        return userMapper.getUserByName(uname);
    }

    public void updateBid(User user) {
        userMapper.updateBid(user);
    }

    @Override
    public User saveUser(User user) {
        return userMapper.saveUser(user);
    }

    @Override
    public boolean deleteByNumber(String number) {
        return userMapper.deleteByNumber(number);
    }

    @Override
    public User searchByNumber(String number) {
        return userMapper.searchByNumber(number);
    }

    public boolean update(User user) {
        return userMapper.update(user);
    }

    @Override
    public Object update(Object o) {
        return userMapper.update((User)o);
    }

    @Override
    public Object insert(Object o) {
        return null;
    }
}
