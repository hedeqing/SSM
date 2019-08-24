package com.northuniversity.service.impl;

import com.northuniversity.model.Admin;
import com.northuniversity.service.AdminService;
import com.northuniversity.service.base.IBaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl extends IBaseServiceImpl<Admin> implements AdminService {
    @Override
    public Object update(Object o) {
        return null;
    }

    @Override
    public Object insert(Object o) {
        return null;
    }


    @Override
    public List<Admin> getAdmin(int id) {
        return null;
    }

    @Override
    public void insertAdmin(String name, String password, String number) {

    }

    @Override
    public List<Admin> selectAllAdmin() {
        return null;
    }

    @Override
    public Admin update(Admin admin) {

        return adminMapper.update(admin);
    }



    @Override
    public Admin getAdminByNumber(String number) {
        return adminMapper.getAdminByNumber(number);
    }


    @Override
    public Admin get(Admin admin) {
        if(!admin.getNumber().equals("") && !admin.getPassword().equals("")){
            return adminMapper.selectAdmin(admin);
        }
        return null;
    }

    @Override
    public void updateBid(Admin user) {

    }

    @Override
    public Admin selectAdmin(Admin admin) {
        return adminMapper.selectAdmin(admin);
    }
}
