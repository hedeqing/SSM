package com.ssm.controller;

import com.alibaba.fastjson.JSON;
import com.mysql.cj.xdevapi.JsonArray;
import com.northuniversity.mapper.ConcentrationMapper;
import com.northuniversity.model.*;
import com.northuniversity.service.ConcentrationService;
import com.northuniversity.service.SensorService;
import com.northuniversity.service.impl.CarServiceImpl;
import com.northuniversity.service.impl.ConcentrationServiceImpl;
import com.northuniversity.service.impl.SensorServiceImpl;
import com.northuniversity.service.impl.UserServiceImpl;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.faces.annotation.RequestMap;
import javax.json.Json;
import javax.lang.model.element.NestingKind;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@RestController
@RequestMapping("/android")
public class AndroidController {

    @Autowired
    private CarServiceImpl carService;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private ConcentrationServiceImpl concentrationService;

    @Autowired
    private SensorServiceImpl sensorService;

    @RequestMapping("findNumberByConcentrationid")
    @ResponseBody
    public String findNumber(HttpServletRequest request){
        String concentrationid = request.getParameter("concentrationid");
        Sensor sensor  = sensorService.findByConcentrationId(concentrationid);
        String license = sensor.getLicense();
        Car car = carService.searchByLicense(license);
        String number =car.getNumber();
        return  number;
    }
    //    @RequestMapping(value = "/login")
//    @ResponseBody
//    public Object login(User user) {
//        Map<String, Object> map = new HashMap<>();
//        int code;
//        String msg;
//        if (userService.get(user) != null) {
//            System.out.println(user);
//            return  userService.get(user);
//        } else {
//            return "error";
//        }
//    }
    @RequestMapping(value = "/login")
    @ResponseBody
    public Map<String, Object> login(User user) {
        Map<String, Object> map = new HashMap<>();
        int code;
        String msg;

        if (userService.get(user) != null) {
            code = 100;
            msg = "登录成功";
            map.put("data", JSONArray.fromObject(userService.get(user)));
        } else {
            code = 200;
            msg = "号码或者密码错误";
            map.put("data", null);

        }
        map.put("code", code);
        map.put("msg", msg);
        map.put("count", null);

        return map;
    }

    @RequestMapping("concentration")
    @ResponseBody
    public Map<String, Object> showView(Concentration concentration, HttpServletRequest request) {
        List<Integer> data_mg = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();

        String number = request.getParameter("number");
        List<Concentration> concentrations = new ArrayList<>();
        String date = request.getParameter("date");
        List<CarShowConcentration> carShowConcentrations = new ArrayList<>();
        List<List<Integer>> data_mg_single = new ArrayList<>();
        List<Car> cars = carService.searchByNumber(number);
        for (Car car : cars) {
            CarShowConcentration carShowConcentration = new CarShowConcentration();
            List<List<Integer>> data_mgs = new ArrayList<>();

            String license = car.getLicense();
            carShowConcentration.setLicense(license);//获得所有车牌
            List<Sensor> sensors = sensorService.searchByLicenseList(license);//找到一辆车的所有的传感器
            System.out.println("sensors " + sensors);
            for (int i = 0; i < sensors.size(); i++) {
                String id = sensors.get(i).getConcentrationId();
                List<Concentration> con = new ArrayList<>();
                concentration.setId(Integer.parseInt(id));
                concentration.setDate(date);
                con = concentrationService.searchByConcentrationIdAndDate(concentration);
                concentrations.addAll(con);
                System.out.println("addALL ");
            }
            List<Integer> data = new ArrayList<>();
            for (int i = 0; i < data.size(); i++) {
                data.add(concentrations.get(i).getData_mg());
            }
            List<List<Integer>> allSensorData = new ArrayList<>();
            for (int i = 0; i < sensors.size(); i++) {
                String id = sensors.get(i).getConcentrationId();
                concentration.setConcentrationId(id);
                List<Integer> sensorSingleData = new ArrayList<>();
                List<Concentration> con = new ArrayList<>();
                con = concentrationService.searchByConcentrationIdAndDate(concentration);
                for (int k = 0; k < con.size(); k++) {
                    sensorSingleData.add(con.get(k).getData_mg());
                }

                allSensorData.add(sensorSingleData);
            }
            data_mgs.addAll(allSensorData);
            carShowConcentration.setData_mg(data_mgs);
            carShowConcentrations.add(carShowConcentration);
        }
        map.put("code", 100);
        map.put("count", carShowConcentrations.size());
        map.put("msg", "获取成功");
        map.put("data", JSONArray.fromObject(carShowConcentrations));
        return map;
    }

    @RequestMapping(value = "/register")
    @ResponseBody
    public Map<String, Object> register(User user) {
        Map<String, Object> map = new HashMap<>();
        int code;
        String msg;
        if (userService.searchByNumber(user.getNumber()) != null) {
            code = 200;
            msg = "该号码已经注册";
            map.put("data", null);
        } else {
            userService.saveUser(user);
            code = 100;
            msg = "注册成功";
            map.put("data", JSONArray.fromObject(user));
        }
        map.put("code", code);
        map.put("msg", msg);
        map.put("count", null);
        return map;
    }

    @RequestMapping("searchShow")
//    @ResponseBody
    public Object search(Concentration concentration, HttpServletRequest request, HttpServletResponse response) {
        System.out.println("search 函数");
        Map<String, Object> map = new HashMap<>();
        String msg = "";
        String license = request.getParameter("license");
        String date = request.getParameter("date");
        List<Sensor> sensors = sensorService.searchByLicenseList(license);
        List<Concentration> concentrations = new ArrayList<>();
        for (int i = 0; i < sensors.size(); i++) {
            String id = sensors.get(i).getConcentrationId();
            concentration.setConcentrationId(id);
            List<Concentration> con = new ArrayList<>();
            con = concentrationService.searchByConcentrationIdAndDate(concentration);
            concentrations.addAll(con);
        }
        List<Integer> data = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            data.add(concentrations.get(i).getData_mg());
        }
        //echart数据格式化

        List<EchartsModel> echartsModels = new ArrayList<>();
//        获取传感器的所有数值
        List<List<Integer>> allSensorData = new ArrayList<>();
        for (int i = 0; i < sensors.size(); i++) {
            String id = sensors.get(i).getConcentrationId();
            concentration.setConcentrationId(id);
            List<Integer> sensorSingleData = new ArrayList<>();

            List<Concentration> con = new ArrayList<>();
            con = concentrationService.searchByConcentrationIdAndDate(concentration);
            for (int k = 0; k < con.size(); k++) {
                sensorSingleData.add(con.get(k).getData_mg());
            }
            allSensorData.add(sensorSingleData);
        }
        System.out.println(allSensorData);
        //获取所有传感器名字,
        List<String> nameList = new ArrayList<>();
        for (int i = 0; i < sensors.size(); i++) {
            EchartsModel echartsModel = new EchartsModel();
            nameList.add(sensors.get(i).getSensorName());
            echartsModel.setName(sensors.get(i).getSensorName());

            echartsModel.setType("line");
            echartsModel.setStack("总量");
            echartsModel.setData(allSensorData.get(i));
            echartsModels.add(echartsModel);
        }
        map.put("series", echartsModels);
        System.out.println(map);
        return map;
    }

    @RequestMapping("insertConcentration")
    @ResponseBody
    public Object insert(Concentration concentration) {
        if(concentrationService.insertConcentration(concentration)!= null){
            return "insert successful";
        }
        else
            return "insert fail";
    }
}
