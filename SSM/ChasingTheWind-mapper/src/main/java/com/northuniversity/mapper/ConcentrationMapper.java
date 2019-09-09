package com.northuniversity.mapper;

import com.northuniversity.model.Concentration;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ConcentrationMapper {

    List<Concentration> selectAllConcentration();
    List<Concentration> searchByConcentrationIdAndDate(@Param("param") Concentration concentration);
    boolean findByConcentrationIdAndDate(@Param("param") Concentration concentration);
    Concentration insertConcentration(@Param("param")Concentration concentration);
}
