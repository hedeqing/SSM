package com.ssm.controller;

import com.northuniversity.model.Car;
import com.northuniversity.model.Sensor;
import com.northuniversity.service.impl.SensorServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller//有数据交互
@RequestMapping("sensor")
public class SensorController {
    @Autowired
    private SensorServiceImpl sensorService;
    Logger log = Logger.getLogger(SensorController.class);



    @RequestMapping("selectAllSensor")
    @ResponseBody
    public Object selectAll() {
        Map param = new HashMap();
        List<Sensor> sensors= sensorService.selectAllSensor();

        param.put("count",sensors.size());
        param.put("code",0);
        param.put("msg","");
        param.put("data",sensors);
        return param;
    }
    @RequestMapping("addSensor")
    public Object insertSensor(Sensor sensor, HttpServletRequest request, HttpServletResponse response) throws ServletException {
//        String userName = request.getParameter("username");
        System.out.println("执行到了add sensor");
        System.out.println("sensor="+ sensor);
        Sensor sensor1 = sensorService.saveSensor(sensor);
        System.out.println("sensor"+sensor1);
        response.setCharacterEncoding("utf-8");
        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.print("<script>alert('添加成功'); window.location='http://localhost:8080/jsp/admin/table/sensor/sensor_add.jsp' </script>");
        } catch (IOException e) {
            e.printStackTrace();
        }

        out.flush();
        out.close();
        return "admin/table/sensor/sensor_add";
    }
    @RequestMapping("addSensorJsp")
    public Object insertSensorJsp(Sensor sensor,HttpServletRequest request) throws ServletException {
//        String userName = request.getParameter("username");
//        System.out.println("user="+user);
//        userService.saveUser(user);
        return "admin/table/sensor/sensor_add";
    }

    @RequestMapping("delete")
    @ResponseBody
    public Map<String,Object> delete(Sensor sensor) {
        Map<String,Object> map = new HashMap<>();
        String msg = "";
        System.out.println(sensor);
        System.out.println(sensor.getLicense());
        if (sensorService.deleteByLicense(sensor.getLicense())){
            msg = "删除成功";
        }
        else {
            msg = "删除失败";
        }
        System.out.println(msg);
        map.put("code",null);
        map.put("msg",msg);
        map.put("count",null);
        map.put("data",null);
        return map;
    }

    @RequestMapping("search")
    @ResponseBody
    public Object search(Sensor sensor,HttpServletRequest request) {
        System.out.println("search 函数");
        Map<String, Object> map = new HashMap<>();
        String msg = "";
        Sensor sensor_find = null;
        List<Sensor> sensors = new ArrayList<>();
        String license = request.getParameter("license");
//        System.out.println("sensor = "+sensor);
//        System.out.println(sensor.getLicense());
//        System.out.println(request.getParameter("number"));
        sensors = sensorService.searchByLicenseList(license);
//        List<Sensor> sensors =new ArrayList<>();
        //注意，data需要是list类型，不然无法正确渲染数据
//        sensors.add(sensor_find);
        System.out.println(sensor_find);
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", sensors.size());
        map.put("data", sensors);
        System.out.println(map);
        return  map;
    }

    @RequestMapping("update")
    @ResponseBody
    public String update(Sensor sensor) {
        if (sensorService.update(sensor)){
            System.out.println("update");
            return "1";
        }
        return "0";
    }

}
