package com.northuniversity.service;

import com.northuniversity.model.Car;

import java.util.List;

public interface CarService {
    //    CarService私有的方法放在这
    List<Car> selectAllCar();
    List<Car> getCar(String license);
    Car get(Car car);
    Car saveCar(Car car);
    boolean update(Car car);
    boolean deleteByLicense(String license);
    Car searchByLicense(String license);

}
