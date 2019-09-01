package com.ssm.controller;

import com.northuniversity.mapper.ConcentrationMapper;
import com.northuniversity.model.*;
import com.northuniversity.service.ConcentrationService;
import com.northuniversity.service.SensorService;
import com.northuniversity.service.impl.CarServiceImpl;
import com.northuniversity.service.impl.ConcentrationServiceImpl;
import com.northuniversity.service.impl.SensorServiceImpl;
import com.northuniversity.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping(value = "/login")
    @ResponseBody
    public Map<String, Object> login(User user) {
        Map<String, Object> map = new HashMap<>();
        int code;
        String msg;

        if (userService.get(user) != null) {
            code = 100;
            msg = "登录成功";
        } else {
            code = 200;
            msg = "登录失败";
        }
        map.put("code", code);
        map.put("msg", msg);
        map.put("count", null);
        map.put("data", null);
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
        System.out.println("sensors = "+sensors);
        System.out.println("concentration ="+concentration);
        List<Concentration> concentrations = new ArrayList<>();
        for (int i = 0; i < sensors.size(); i++) {
            String id = sensors.get(i).getConcentrationId();
            concentration.setConcentrationId(id);
            List<Concentration> con = new ArrayList<>();
            con = concentrationService.searchByConcentrationIdAndDate(concentration);
            concentrations.addAll(con);
        }
        List<Integer> data = new ArrayList<>();
        for(int i=0;i<data.size();i++){
            data.add(concentrations.get(i).getData_mg());
        }
//        map.put("code", 0);
//        map.put("msg", "");
//        map.put("count", concentrations.size());

//        map.put("series", concentrations);
        //注意，data需要是list类型，不然无法正确渲染数据


        //echart数据格式化

        List<EchartsModel> echartsModels = new ArrayList<>();
//        获取传感器的所有数值
        List<List<Integer>> allSensorData = new ArrayList<>();
         for(int i = 0;i<sensors.size();i++){
                 String id = sensors.get(i).getConcentrationId();
                 concentration.setConcentrationId(id);
             List<Integer>  sensorSingleData = new ArrayList<>();

             List<Concentration> con = new ArrayList<>();
                 con = concentrationService.searchByConcentrationIdAndDate(concentration);
                 for (int k = 0;k<con.size();k++){
                     sensorSingleData.add(con.get(k).getData_mg());
                 }

             allSensorData.add(sensorSingleData);
        }


        System.out.println(allSensorData);


        //获取所有传感器名字,
        List<String> nameList = new ArrayList<>();
        for (int i =0;i<sensors.size();i++){
            EchartsModel echartsModel = new EchartsModel();
            nameList.add(sensors.get(i).getSensorName());
            echartsModel.setName(sensors.get(i).getSensorName());

            echartsModel.setType("line");
            echartsModel.setStack("总量");
            echartsModel.setData(allSensorData.get(i));
            echartsModels.add(echartsModel);
        }
        map.put("series",echartsModels);
        System.out.println(map);
        return map;
    }
//    @RequestMapping("searchShow")
////    @ResponseBody
//    public Object search(Concentration concentration, HttpServletRequest request, HttpServletResponse response) {
//        System.out.println("search 函数");
//        Map<String, Object> map = new HashMap<>();
//        String msg = "";
//        String license = request.getParameter("license");
//        String date = request.getParameter("date");
//        List<Sensor> sensors = sensorService.searchByLicenseList(license);
//        System.out.println("sensors = "+sensors);
//        System.out.println("concentration ="+concentration);
//        List<Concentration> concentrations = new ArrayList<>();
//        for (int i = 0; i < sensors.size(); i++) {
//            String id = sensors.get(i).getConcentrationId();
//            concentration.setConcentrationId(id);
//            List<Concentration> con = new ArrayList<>();
//            con = concentrationService.searchByConcentrationIdAndDate(concentration);
//            concentrations.addAll(con);
//        }
//        List<Integer> data = new ArrayList<>();
//        for(int i=0;i<data.size();i++){
//            data.add(concentrations.get(i).getData_mg());
//        }
//        map.put("code", 0);
//        map.put("msg", "");
//        map.put("count", concentrations.size());
//        map.put("data", concentrations);
//        //注意，data需要是list类型，不然无法正确渲染数据
//        return map;
//    }
}
