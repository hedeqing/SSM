package com.ssm.controller;

import com.northuniversity.model.User;
import com.northuniversity.service.UserService;
import com.northuniversity.service.impl.UserServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * created by hedeqing on 2018/07/04
 * controller层接口类
 */
//@Controller//无数据交互，页面跳转
@RestController//有数据交互
//@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;
    Logger log = Logger.getLogger(UserController.class);

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView toIndex() {
        ModelAndView mv = new ModelAndView("index");
        return mv;
    }

    @RequestMapping("select")
    @ResponseBody
    public Object userTest(int id) {
        System.out.println("测试成功~~" + id);
        List<User> user = userService.getUser(id);
        System.out.println(user.toString());
        log.info(user);
        return user;
    }

    @RequestMapping("addUser")
    public Object insertUser(String uName, String uPassword, int uGender, String uNumber, String uAvator) {
        userService.insertUser(uName, uPassword, uGender, uNumber, uAvator);
        return "OK";
    }

    @RequestMapping("selectAll")
    public Object selectAll() {
        Map param = new HashMap();
        List<User> users= userService.selectAll();

        param.put("count",users.size());
        param.put("code",0);
        param.put("msg","");
        param.put("data",users);
        return param;
    }
    @RequestMapping("update")
    public Object update() {
        return userService.update();
    }

}
