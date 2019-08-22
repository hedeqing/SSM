package com.northuniversity.service.impl;

import com.northuniversity.model.Car;
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
}
