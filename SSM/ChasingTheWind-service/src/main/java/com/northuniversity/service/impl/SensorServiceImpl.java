package com.northuniversity.service.impl;

import com.northuniversity.model.Sensor;
import com.northuniversity.service.SensorService;
import com.northuniversity.service.base.IBaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SensorServiceImpl extends IBaseServiceImpl implements SensorService {
    @Override
    public Object update(Object o) {
        return null;
    }

    @Override
    public Object insert(Object o) {
        return null;
    }



    @Override
    public List<Sensor> selectAllSensor() {
        return sensorMapper.selectAllSensor();
    }
}
