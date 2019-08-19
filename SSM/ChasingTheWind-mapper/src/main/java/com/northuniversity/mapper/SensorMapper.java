package com.northuniversity.mapper;

import com.northuniversity.model.Sensor;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SensorMapper {
    List<Sensor> selectAllSensor();
}
