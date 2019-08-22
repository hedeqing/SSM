package com.northuniversity.service;

import com.northuniversity.model.Sensor;
import com.northuniversity.model.User;

import java.util.List;

public interface SensorService{
    //SensorService私有的方法放在这
    List<Sensor> selectAllSensor();

}
