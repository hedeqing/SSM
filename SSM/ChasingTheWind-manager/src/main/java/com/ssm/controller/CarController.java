package com.ssm.controller;

import com.northuniversity.model.Car;
import com.northuniversity.model.Sensor;
import com.northuniversity.service.CarService;
import com.northuniversity.service.SensorService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController//有数据交互
public class CarController {
    @Autowired
    private CarService carService;
    Logger log = Logger.getLogger(CarController.class);



    @RequestMapping("selectAllCar")
    public Object selectAll() {
        Map param = new HashMap();
        List<Car> cars= carService.selectAllCar();

        param.put("count",cars.size());
        param.put("code",0);
        param.put("msg","");
        param.put("data",cars);
        return param;
    }
}
