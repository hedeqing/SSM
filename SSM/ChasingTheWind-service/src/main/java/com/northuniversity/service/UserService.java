package com.northuniversity.service;

import com.northuniversity.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * created by viking on 2018/07/04
 * 业务层接口
 */

public interface UserService {
     List<User> getUser(int id);

     void insertUser(int id, String name, int age, String sex);

     List<User> selectAll();

     Object update();

     User getUserByName(String uname);

     void updateBid(User user);
}
