package com.ssm.controller;

import com.northuniversity.model.Sensor;
import com.northuniversity.model.User;
import com.northuniversity.service.SensorService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController//有数据交互
public class SensorController {
    @Autowired
    private SensorService  sensorService;
    Logger log = Logger.getLogger(SensorController.class);



    @RequestMapping("selectAllSensor")
    public Object selectAll() {
        Map param = new HashMap();
        List<Sensor> sensors= sensorService.selectAllSensor();

        param.put("count",sensors.size());
        param.put("code",0);
        param.put("msg","");
        param.put("data",sensors);
        return param;
    }
}
