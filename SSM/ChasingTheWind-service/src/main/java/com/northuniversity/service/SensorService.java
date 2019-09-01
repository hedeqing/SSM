package com.northuniversity.service;

import com.northuniversity.model.Sensor;
import com.northuniversity.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SensorService{
    //SensorService私有的方法放在这
    List<Sensor> selectAllSensor();
    List<Sensor> getSensor(String license);
    Sensor get(Sensor sensor);
    Sensor saveSensor(Sensor sensor);
    boolean deleteByLicense(String license);
    Sensor searchByLicense(String license);
    boolean update(@Param("param") Sensor sensor);
    List<Sensor> searchByLicenseList(String license);


}
