package com.northuniversity.mapper;

import com.northuniversity.model.Car;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CarMapper {
    List<Car> selectAllCar();
    List<Car> getCar(String license);
    Car get(@Param("param") Car car);
    Car saveCar(@Param("param") Car car);
    boolean deleteByLicense(String license);
    Car searchByLicense(String license);
    boolean update(@Param("param") Car car);
}
