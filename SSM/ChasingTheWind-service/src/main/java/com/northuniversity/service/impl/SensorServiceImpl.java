package com.northuniversity.service.impl;

import com.northuniversity.model.Sensor;
import com.northuniversity.service.SensorService;
import com.northuniversity.service.base.IBaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SensorServiceImpl extends IBaseServiceImpl<Sensor> implements SensorService {
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

    @Override
    public List<Sensor> getSensor(String license) {
        return sensorMapper.getSensor(license);
    }

    @Override
    public Sensor get(Sensor sensor) {
        return sensorMapper.get(sensor);
    }

    @Override
    public Sensor saveSensor(Sensor sensor) {
        return sensorMapper.saveSensor(sensor);
    }

    @Override
    public boolean deleteByLicense(String license) {
        return sensorMapper.deleteByLicense(license);
    }

    @Override
    public Sensor searchByLicense(String license) {
        return sensorMapper.searchByLicense(license);
    }

    @Override
    public boolean update(Sensor sensor) {
        return sensorMapper.update(sensor);
    }

    @Override
    public List<Sensor> searchByLicenseList(String license) {
        return sensorMapper.searchByLicenseList(license);
    }

    @Override
    public Sensor findByConcentrationId(String concentrationId) {
        return sensorMapper.findByConcentrationId(concentrationId);
    }
}
