package com.northuniversity.service.impl;

import com.northuniversity.model.Concentration;
import com.northuniversity.service.ConcentrationService;
import com.northuniversity.service.base.IBaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConcentrationServiceImpl extends IBaseServiceImpl<Concentration> implements ConcentrationService {
    @Override
    public Object update(Object o) {
        return null;
    }

    @Override
    public Object insert(Object o) {
        return null;
    }


    @Override
    public List<Concentration> selectAllConcentration() {
        return concentrationMapper.selectAllConcentration();
    }

    @Override
    public List<Concentration> searchByConcentrationIdAndDate(Concentration concentration) {
        return concentrationMapper.searchByConcentrationIdAndDate(concentration);
    }

    @Override
    public boolean findByConcentrationIdAndDate(Concentration concentration) {
        return concentrationMapper.findByConcentrationIdAndDate(concentration);
    }

    @Override
    public Concentration insertConcentration(Concentration concentration) {
        return concentrationMapper.insertConcentration(concentration);
    }


}
