package com.ssm.controller;

import com.northuniversity.model.Concentration;
import com.northuniversity.model.Sensor;
import com.northuniversity.service.ConcentrationService;
import com.northuniversity.service.SensorService;
import com.northuniversity.service.impl.ConcentrationServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("concentration")
public class ConcentrationController {
    @Autowired
    private ConcentrationServiceImpl concentrationService;
    Logger log = Logger.getLogger(ConcentrationController.class);

    @RequestMapping("selectAllConcentration")
    @ResponseBody
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
