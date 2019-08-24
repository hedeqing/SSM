package com.northuniversity.mapper;


import com.northuniversity.model.User;
import org.apache.ibatis.annotations.Param;


import java.util.List;
import java.util.Map;

/**
 * created by viking on 2018/07/04
 * dao层接口
 */
public interface UserMapper {
    List<User> getUser(@Param("param") Map map);

    void insertUser(@Param("param") Map param);

    List<User> selectAllUser();

    void update(@Param("param") Map param);

    User getUserByName(@Param("param") String uname);

    User getUser(@Param("param") String Number);

    void updateBid(@Param("param") User user);
    User selectUser(@Param("param") User user);
}
