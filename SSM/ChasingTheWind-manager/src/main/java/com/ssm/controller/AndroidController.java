package com.ssm.controller;

import com.northuniversity.model.User;
import com.northuniversity.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;
@Controller
@RequestMapping("/android")
public class AndroidController {
    @Autowired
    private UserServiceImpl userService;

    @RequestMapping(value = "/login")
    @ResponseBody
    public Map<String ,Object> login(User user){
        Map<String,Object> map = new HashMap<>();
        int code;
        String msg;

        if (userService.get(user) != null){
            code = 100;
            msg = "登录成功";
        }else {
            code = 200;
            msg = "登录失败";
        }
        map.put("code",code);
        map.put("msg",msg);
        map.put("count",null);
        map.put("data",null);
        return map;
    }
}
