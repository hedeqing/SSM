package com.northuniversity.service.base;

import com.northuniversity.mapper.UserMapper;
import com.northuniversity.service.base.IBaseService;
import org.springframework.beans.factory.annotation.Autowired;

public abstract  class IBaseServiceImpl<T> implements IBaseService {
    @Autowired
    public UserMapper userMapper;
}
