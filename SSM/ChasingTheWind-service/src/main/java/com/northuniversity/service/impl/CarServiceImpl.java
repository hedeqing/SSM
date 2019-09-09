package com.northuniversity.service.impl;

import com.northuniversity.model.Car;
import com.northuniversity.model.User;
import com.northuniversity.service.CarService;
import com.northuniversity.service.base.IBaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl extends IBaseServiceImpl<Car> implements CarService {
    @Override
    public Object update(Object o) {
        return null;
    }

    @Override
    public Object insert(Object o) {
        return null;
    }

    @Override
    public List<Car> selectAllCar() {
        return carMapper.selectAllCar();
    }

    @Override
    public List<Car> getCar(String license) {
        return carMapper.getCar(license);
    }

    @Override
    public Car get(Car car) {
        return carMapper.get(car);
    }

    @Override
    public Car saveCar(Car car) {
        return carMapper.saveCar(car);
    }

    @Override
    public boolean update(Car car) {
        return carMapper.update(car);
    }

    @Override
    public boolean deleteByLicense(String license) {
        return carMapper.deleteByLicense(license);
    }

    @Override
    public Car searchByLicense(String license) {
        return carMapper.searchByLicense(license);
    }

    @Override
    public List<Car> searchByNumber(String number) {
        return carMapper.searchByNumber(number);
    }
}
