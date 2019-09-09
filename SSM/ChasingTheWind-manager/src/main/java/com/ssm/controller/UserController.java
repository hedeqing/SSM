package com.ssm.controller;

import com.northuniversity.model.User;
import com.northuniversity.service.impl.UserServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * created by hedeqing on 2018/07/04
 * controller层接口类
 */
@Controller//无数据交互，页面跳转
//@RestController//有数据交互
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    public  static User myuser;
    Logger log = Logger.getLogger(UserController.class);


    @RequestMapping("select")
    @ResponseBody
    public Object userTest(int id) {
        System.out.println("测试成功~~" + id);
        List<User> user = userService.getUser(id);
//        System.out.println(user.toString());
        log.info(user);
        return user;
    }


    @RequestMapping("addUser")
    public Object insertUser(User user, HttpServletRequest request, HttpServletResponse response) throws ServletException {
//        String userName = request.getParameter("username");
        System.out.println("user="+user);
        userService.saveUser(user);
        response.setCharacterEncoding("utf-8");
        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.print("<script>alert('添加成功'); window.location='http://localhost:8080/jsp/admin/table/user/user_add.jsp' </script>");
        } catch (IOException e) {
            e.printStackTrace();
        }

        out.flush();
        out.close();
        return "admin/table/user/user_add";
    }
    @RequestMapping("addUserJsp")
    public Object insertUserJsp(User user,HttpServletRequest request) throws ServletException {
//        String userName = request.getParameter("username");
//        System.out.println("user="+user);
//        userService.saveUser(user);
        return "admin/table/user/user_add";
    }

    @RequestMapping("selectAllUser")
    @ResponseBody
    public Object selectAll() {
        Map param = new HashMap();
        List<User> users= userService.selectAllUser();
        param.put("count",users.size());
        param.put("code",0);
        param.put("msg","");
        param.put("data",users);
        return param;
    }
    @RequestMapping("update")
    @ResponseBody
    public String update(User user) {

        if (userService.update(user)){
            System.out.println("update");
            return "1";
        }
        return "0";

    }


    @RequestMapping("delete")
    @ResponseBody
    public Map<String,Object> delete(User user) {
        Map<String,Object> map = new HashMap<>();
        String msg = "";
        System.out.println(user);
        System.out.println(user.getNumber());
        if (userService.deleteByNumber(user.getNumber())){
            msg = "删除成功";
        }
        else {
            msg = "删除失败";
        }
        System.out.println(msg);
        map.put("code",null);
        map.put("msg",msg);
        map.put("count",null);
        map.put("data",null);
        return map;
    }

    @RequestMapping("search")
    @ResponseBody
    public Object search(User user,HttpServletRequest request) {
        System.out.println("search 函数");
        Map<String, Object> map = new HashMap<>();
        String msg = "";
        User user_find = null;
        System.out.println(user.getNumber());
//        System.out.println(request.getParameter("number"));
        user_find = userService.searchByNumber(user.getNumber());
        List<User> users =new ArrayList<>();
        //注意，data需要是list类型，不然无法正确渲染数据
        users.add(user_find);
        System.out.println(user_find);
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", 1);
        map.put("data", users);
        System.out.println(map);
        return  map;
    }
}
