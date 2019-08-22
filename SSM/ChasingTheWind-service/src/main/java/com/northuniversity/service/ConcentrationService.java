package com.northuniversity.service;

import com.northuniversity.model.Concentration;

import java.util.List;

public interface ConcentrationService {
    //ConcentrationService私有的方法放在这
    List<Concentration> selectAllConcentration();

}
