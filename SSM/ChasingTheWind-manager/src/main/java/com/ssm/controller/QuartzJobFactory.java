package com.ssm.controller;

import org.json.JSONArray;
import org.json.JSONObject;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class QuartzJobFactory implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
//        System.out.println("=================我是定时任务,每隔5秒执行一次==============");
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
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
