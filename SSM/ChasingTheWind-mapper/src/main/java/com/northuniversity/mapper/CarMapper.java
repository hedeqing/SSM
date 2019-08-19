package com.northuniversity.mapper;

import com.northuniversity.model.Car;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CarMapper {
    List<Car> selectAllCar();
}
