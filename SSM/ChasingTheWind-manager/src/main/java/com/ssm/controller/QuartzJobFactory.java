package com.ssm.controller;//package com.ssm.controller;

import com.northuniversity.model.Car;
import com.northuniversity.model.Concentration;
import com.northuniversity.model.Sensor;
import com.northuniversity.service.impl.CarServiceImpl;
import com.northuniversity.service.impl.ConcentrationServiceImpl;
import com.northuniversity.service.impl.SensorServiceImpl;
import org.json.JSONArray;
import org.json.JSONObject;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import utils.GetPostUtil;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;
//定时任务（在web.xml中定义）
public class QuartzJobFactory implements Job {

    @Autowired
    public ConcentrationServiceImpl concentrationService = new ConcentrationServiceImpl();

    @Autowired
    public SensorServiceImpl sensorService;

    @Autowired
    public CarServiceImpl carService;

    int index = 0;
    private static int turn = 0;
    private static int time = 0;
    private static int concentrationId = 1;

    public String getDate() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy");//设置日期格式
        String year = df.format(new Date());
        SimpleDateFormat df1 = new SimpleDateFormat("MM");//设置日期格式
        String month = df1.format(new Date());
        SimpleDateFormat df2 = new SimpleDateFormat("dd");//设置日期格式
        String day = df2.format(new Date());
        String date = year + month + day;
        return date;
    }

    public String findNumber(String concentrationid) {
//        String concentrationid = request.getParameter("concentrationid");
        Sensor sensor = sensorService.findByConcentrationId(concentrationid);
        String license = sensor.getLicense();
        Car car = carService.searchByLicense(license);
        String number = car.getNumber();
        return number;
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
//        System.out.println("=================我是定时任务,每隔5秒执行一次==============");
        turn++;
        System.out.println(" 第  " + turn + " 次");
        if (time >= 23) {
            time = 0;
            concentrationId++;
        }
        if (turn == 3) {
            turn = 0;
            try {
                final Concentration concentration = new Concentration();
                concentration.setDate(getDate());
                concentration.setTime(time);
                concentration.setConcentrationId(String.valueOf(concentrationId));
                final String url = "http://192.168.0.1/cgi-bin/node.cgi/";
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
                JSONObject jsonObject = jsonArray.getJSONObject(5);
                JSONArray jsonArray1 = jsonObject.getJSONArray("funcList");
                System.out.println(jsonArray1);
                JSONObject jsonObject1 = jsonArray1.getJSONObject(0);
                System.out.println(jsonObject1.getDouble("data"));
                concentration.setData_mg((int) jsonObject1.getDouble("data") - 300);
                final String url1 = "http://localhost:8080/android/insertConcentration?";
                final String param = "concentrationId=" + concentrationId + "&date=" + getDate() + "&time=" + time + "&data_mg=" + concentration.getData_mg();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        if (concentration.getData_mg() > 100) {
                            String numberUrl = "http://localhost:8080/android/findNumberByConcentrationid?concentrationid=" + concentrationId;
                            String number = GetPostUtil.sendPostRequest(numberUrl, null);
                            System.out.println("预警号码="+number);
                            number= number.replace("\"", "");
                            System.out.println("number = "+number);
                            String url_alart = "http://api.vm.ihuyi.com/webservice/voice.php?method=Submit&account=VM15920313&password=cdb6de36a3064623156a6fcf6983e19d&mobile=" +number+ "&content=警报警报，您的车辆有毒气体已经达到阈值，请打开窗户通风！";
                            String alartResult = GetPostUtil.sendPostRequest(url_alart, null);
                            System.out.println("预警返回结果" + alartResult);
                        }
                        String result = GetPostUtil.sendPostRequest(url1, param);
                        System.out.println("保存数据库结果" + result);
                    }
                }).start();

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
            time += 2;
        }

    }
}
