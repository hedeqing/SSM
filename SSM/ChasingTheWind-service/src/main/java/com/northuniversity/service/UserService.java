package com.northuniversity.service;


import com.northuniversity.model.User;

import java.util.List;

/**
 * created by viking on 2018/07/04
 * 业务层接口
 */

public interface UserService {
     //user私有的方法放在这
     List<User> getUser(int id);

     void insertUser(String uName, String uPassword, int uGender, String uNumber, String uAvator);

     List<User> selectAllUser();

//     boolean update(User user);

     User getUserByNumber(String number);
     User get(User user);

     void updateBid(User user);

     User saveUser(User user);
     boolean deleteByNumber(String number);
     User searchByNumber(String number);
}
