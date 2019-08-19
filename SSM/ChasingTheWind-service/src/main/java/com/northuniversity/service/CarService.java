package com.northuniversity.service;

import com.northuniversity.model.Car;

import java.util.List;

public interface CarService {
    //    CarService私有的方法放在这
    List<Car> selectAllCar();

}
