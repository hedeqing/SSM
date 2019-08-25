package com.ssm.controller;

import com.northuniversity.model.Car;
import com.northuniversity.model.Sensor;
import com.northuniversity.model.User;
import com.northuniversity.service.CarService;
import com.northuniversity.service.SensorService;
import com.northuniversity.service.impl.CarServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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

@RequestMapping("car")
public class CarController {

    @Autowired
    private CarServiceImpl carService;
    Logger log = Logger.getLogger(CarController.class);

    @RequestMapping("selectAllCar")
    @ResponseBody
    public Object selectAll() {
        Map param = new HashMap();
        List<Car> cars= carService.selectAllCar();

        param.put("count",cars.size());
        param.put("code",0);
        param.put("msg","");
        param.put("data",cars);
        return param;
    }

    @RequestMapping("addCar")
    public Object insertCar(Car car, HttpServletRequest request, HttpServletResponse response) throws ServletException {
//        String userName = request.getParameter("username");
        System.out.println("user="+car);
        Car car1 = carService.saveCar(car);
        System.out.println("car"+car1);
        response.setCharacterEncoding("utf-8");
        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.print("<script>alert('添加成功'); window.location='http://localhost:8080/jsp/admin/table/car/car_add.jsp' </script>");
        } catch (IOException e) {
            e.printStackTrace();
        }

        out.flush();
        out.close();
        return "admin/table/car/car_add";
    }
    @RequestMapping("addCarJsp")
    public Object insertCarJsp(Car car,HttpServletRequest request) throws ServletException {
//        String userName = request.getParameter("username");
//        System.out.println("user="+user);
//        userService.saveUser(user);
        return "admin/table/car/car_add";
    }

    @RequestMapping("delete")
    @ResponseBody
    public Map<String,Object> delete(Car car) {
        Map<String,Object> map = new HashMap<>();
        String msg = "";
        System.out.println(car);
        System.out.println(car.getNumber());
        if (carService.deleteByLicense(car.getLicense())){
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
    public Object search(Car car,HttpServletRequest request) {
        System.out.println("search 函数");
        Map<String, Object> map = new HashMap<>();
        String msg = "";
        Car car_find = null;
        System.out.println(car.getLicense());
//        System.out.println(request.getParameter("number"));
        car_find = carService.searchByLicense(car.getLicense());
        List<Car> cars =new ArrayList<>();
        //注意，data需要是list类型，不然无法正确渲染数据
        cars.add(car_find);
        System.out.println(car_find);
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", 1);
        map.put("data", cars);
        System.out.println(map);
        return  map;
    }

    @RequestMapping("update")
    @ResponseBody
    public String update(Car car) {
        if (carService.update(car)){
            System.out.println("update");
            return "1";
        }
        return "0";
    }
}
