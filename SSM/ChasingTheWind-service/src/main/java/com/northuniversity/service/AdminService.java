package com.northuniversity.service;

import com.northuniversity.model.Admin;
import org.apache.ibatis.annotations.Param;


import java.util.List;

public interface AdminService {
    //user私有的方法放在这
    List<Admin> getAdmin(int id);

    void insertAdmin(String name, String password, String number);

    List<Admin> selectAllAdmin();

    Admin update(Admin admin);
    Admin updatePsd(Admin admin);

    Admin getAdminByNumber(String number);
    Admin get(Admin admin);

    void updateBid(Admin admin);
    Admin selectAdmin(Admin admin);

}
