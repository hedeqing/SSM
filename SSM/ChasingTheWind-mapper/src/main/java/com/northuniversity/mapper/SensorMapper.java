package com.northuniversity.mapper;

import com.northuniversity.model.Car;
import com.northuniversity.model.Sensor;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SensorMapper {
    List<Sensor> selectAllSensor();
    List<Sensor> getSensor(String license);
    Sensor get(@Param("param") Sensor sensor);
    Sensor saveSensor(@Param("param") Sensor sensor);
    boolean deleteByLicense(String license);
    Sensor searchByLicense(String license);
    boolean update(@Param("param") Sensor sensor);
    List<Sensor> searchByLicenseList(String license);

}
