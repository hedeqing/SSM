package com.northuniversity.service;

import com.northuniversity.model.Concentration;
import com.northuniversity.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ConcentrationService {
    //ConcentrationService私有的方法放在这
    List<Concentration> selectAllConcentration();
//    List<Concentration> getConcentration(int id);
//    Concentration get(Concentration concentration);
//    Concentration saveConcentration(Concentration concentration);
//    boolean deleteByNumber(String number);
//    Concentration searchByNumber(String number);
    List<Concentration> searchByConcentrationIdAndDate(Concentration concentration);
    boolean findByConcentrationIdAndDate( Concentration concentration);
    Concentration insert(Concentration concentration);

}
