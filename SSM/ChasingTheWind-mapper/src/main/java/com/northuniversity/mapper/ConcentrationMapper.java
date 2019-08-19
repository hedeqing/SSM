package com.northuniversity.mapper;

import com.northuniversity.model.Concentration;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ConcentrationMapper {

    List<Concentration> selectAllConcentration();

}
