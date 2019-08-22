package com.ssm.controller;

import com.northuniversity.model.Concentration;
import com.northuniversity.model.Sensor;
import com.northuniversity.service.ConcentrationService;
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
public class ConcentrationController {
    @Autowired
    private ConcentrationService concentrationService;
    Logger log = Logger.getLogger(ConcentrationController.class);



    @RequestMapping("selectAllConcentration")
    public Object selectAll() {
        Map param = new HashMap();
        List<Concentration> concentrations= concentrationService.selectAllConcentration();

        param.put("count",concentrations.size());
        param.put("code",0);
        param.put("msg","");
        param.put("data",concentrations);
        return param;
    }
}
