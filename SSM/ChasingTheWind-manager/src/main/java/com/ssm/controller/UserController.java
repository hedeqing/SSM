package com.ssm.controller;

import com.northuniversity.model.User;
import com.northuniversity.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * created by hedeqing on 2018/07/04
 * controller层接口类
 */
//@Controller//无数据交互，页面跳转
@RestController//有数据交互
//@RequestMapping("user")
public class UserController {
    @Autowired
    private  UserService userService;
    Logger log = Logger.getLogger(UserController.class);

    @RequestMapping("index")
    public String index(){
        return "index";
    }

    @RequestMapping("select")
    @ResponseBody
    public Object userTest(int id){
        System.out.println("测试成功~~"+id);
        List<User> user = userService.getUser(id);
        System.out.println(user.toString());
        log.info(user);
        return user;
    }

    @RequestMapping("addUser")
    public Object insertUser(String uName, String uPassword, int uGender, String uNumber, String uAvator){
        userService.insertUser(uName,  uPassword,  uGender,  uNumber,  uAvator);
        return "OK";
    }

    @RequestMapping("selectAll")
    public Object selectAll(){
        return userService.selectAll();
    }
    @RequestMapping("update")
    public Object update(){
        return userService.update();
    }

}
