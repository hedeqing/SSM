package com.northuniversity.mapper;

import com.northuniversity.model.Admin;
import com.northuniversity.model.User;
import org.apache.ibatis.annotations.Param;

public interface AdminMapper {
    Admin selectAdmin(@Param("param") Admin admin);

    Admin getAdminByNumber(String number);
//    Admin selectAd(@Param("param") Admin admin);
    Admin update(@Param("param")Admin admin);
    Admin updatePsd(@Param("param")Admin admin);
}
