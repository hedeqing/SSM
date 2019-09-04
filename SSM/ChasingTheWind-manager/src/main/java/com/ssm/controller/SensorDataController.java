package com.ssm.controller;


import com.alibaba.fastjson.JSON;
import com.mysql.cj.xdevapi.JsonArray;
import com.northuniversity.service.impl.ConcentrationServiceImpl;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("hardware")
public class SensorDataController {


    @Autowired
    private ConcentrationServiceImpl concentrationService;
    @RequestMapping("insertMonitor")
    @ResponseBody
    public String insertMonitor() {
        try {
            String url = "http://192.168.0.1/cgi-bin/node.cgi/";
            StringBuilder stringBuilder = new StringBuilder();
            URL mine_url = new URL(url);
            URLConnection connection = mine_url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
            String input_line = null;
            while ((input_line = in.readLine()) != null) {
                stringBuilder.append(input_line);
            }
            in.close();
            JSONArray jsonArray = new JSONArray(stringBuilder.toString());
            JSONObject jsonObject = jsonArray.getJSONObject(2);
            JSONArray jsonArray1 = jsonObject.getJSONArray("funcList");
            System.out.println(jsonArray1);
            JSONObject jsonObject1= jsonArray1.getJSONObject(0);
            System.out.println(jsonObject1.getDouble("data"));
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return "failed";
    }
}
