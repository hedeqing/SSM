package com.ssm.controller;


import com.northuniversity.model.Admin;
import com.northuniversity.model.User;
import com.northuniversity.service.impl.AdminServiceImpl;
import com.sun.net.httpserver.HttpsParameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.ejb.ApplicationException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@Controller//有数据交互
@RequestMapping("admin")
public class AdminController {
    @Autowired
    private AdminServiceImpl adminService;

     public  static  String number;
    //登录
    @RequestMapping(value = "/login")
    public String login(Admin admin, HttpSession session){
        if (adminService.get(admin) != null){
//            System.out.println(admin.getNumber());
//            System.out.println( adminService.getAdminByNumber(admin.getNumber()));
            Admin admin1 = adminService.getAdminByNumber(admin.getNumber());
            number = admin1.getNumber();
            session.setAttribute("SESSION_USER_id",admin1.getId());
            session.setAttribute("SESSION_USER_number",admin1.getNumber().trim());
            session.setAttribute("SESSION_USER_psd",admin1.getPassword().trim());
            session.setAttribute("SESSION_USER_username",admin1.getName().trim());
            System.out.println(admin1.getName().trim());

            return "admin/appCount/index";
        }else {
            return "redirect:/jsp/admin/index/login.jsp";
        }
    }

    @RequestMapping("update_admin_info")
    public  String updateAdminInfo(Admin admin,HttpSession session){

        if (adminService.update(admin)!=null){
            System.out.println(adminService.update(admin));
            Admin admin1 = adminService.update(admin);
            session.setAttribute("SESSION_USER_id",admin1.getId());
//            session.setAttribute("SESSION_USER_admin",admin1);
//            System.out.println(admin1);
            session.setAttribute("SESSION_USER_number",admin1.getNumber().trim());
            session.setAttribute("SESSION_USER_psd",admin1.getPassword().trim());
            session.setAttribute("SESSION_USER_username",admin1.getName().trim());
            return "admin/index/admin-info";
        }
        return "admin/index/admin-info";
    }
    @RequestMapping("update_admin_psd")
    public  String  updateAdminPsd(Admin admin ,HttpServletRequest request,
                                   HttpServletResponse response) throws ServletException, IOException {
//        System.out.println("执行到了changePassword函数");
//        PrintWriter pw = response.getWriter();
        //找到保存到session中的登录用户
        String number = (String) request.getParameter("number");
//        System.out.println(number);
//        Admin admin_old = adminService.getAdminByNumber(number);
//        Admin user =  (Admin) request.getSession().getAttribute("SESSION_USER_admin");
        //通过用户id重新查找用户
        Admin admin_new = adminService.getAdminByNumber(number);

        //加载用户所属部门和角色，解决懒加载的问题
//        Hibernate.initialize(userNow.getDepartment());
//        Hibernate.initialize(userNow.getSystemRole());

        String oldpwd = request.getParameter("old_password");//旧密码
        String newpwd = request.getParameter("new_password");//新密码
        String confirm = request.getParameter("repeat_password");//确认新密码
//         System.out.println("旧密码"+oldpwd);
//        System.out.println("新密码"+newpwd);
//        System.out.println("验证密码"+confirm);
        String pwd = admin_new.getPassword();//得到该客户当前的密码
        admin_new.setNumber(number);
//        System.out.println(admin_new);
        try{
            if(oldpwd.equals(pwd)){ //输入的旧密码与原密码一致
                if(newpwd.equals(confirm)){//判断输入的两个新密码是否一致
                    if(!(newpwd).equals(pwd)){//如果新密码与原密码不同，执行更新密码操作
                        admin_new.setPassword(newpwd);
                        adminService.updatePsd(admin_new);
                        return  "redirect:/jsp/admin/index/login.jsp";
//                        exit(request, response);
                    }else if(newpwd.equals(pwd)){
//                        throw new ApplicationException("密码没有改动");
                        System.out.println("密码没有改动");
                        return "0";
                    }
                }else{//抛出异常
//                    throw new ApplicationException("抱歉，密码输入不一致");
                    System.out.println("抱歉，密码输入不一致");
                    return  "0";
                }
            }else{//抛出异常
//                throw new ApplicationException("旧密码输入错误");
                System.out.println("旧密码输入错误");
            }
        }catch(Exception e){
            System.out.println("error");
//            request.setAttribute("error", e);
//
//            request.getRequestDispatcher("/jsps/error.jsp").forward(request, response);
        }

        return  "0";
    }
}
