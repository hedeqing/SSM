package com.northuniversity.service.base;

import com.northuniversity.mapper.*;
import com.northuniversity.model.Admin;
import com.northuniversity.model.Car;
import com.northuniversity.model.Concentration;
import com.northuniversity.model.Sensor;
import com.northuniversity.service.base.IBaseService;
import org.springframework.beans.factory.annotation.Autowired;

public abstract  class IBaseServiceImpl<T> implements IBaseService {
    @Autowired
    public UserMapper userMapper;
    @Autowired
    public CarMapper carMapper;
    @Autowired
    public ConcentrationMapper concentrationMapper;
    @Autowired
    public SensorMapper sensorMapper;
    @Autowired
    public AdminMapper adminMapper;
}
