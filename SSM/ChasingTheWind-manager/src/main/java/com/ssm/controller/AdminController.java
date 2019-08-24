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

import javax.servlet.http.HttpSession;

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
            session.setAttribute("SESSION_USER_number",admin1.getNumber().trim());
            session.setAttribute("SESSION_USER_psd",admin1.getPassword().trim());
            session.setAttribute("SESSION_USER_username",admin1.getName().trim());
            return "admin/index/admin-info";
        }
        return "admin/index/admin-info";
    }
}
