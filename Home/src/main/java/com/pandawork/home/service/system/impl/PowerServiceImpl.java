package com.pandawork.home.service.system.impl;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.core.common.log.LogClerk;
import com.pandawork.core.common.util.Assert;
import com.pandawork.home.common.entity.system.Power;
import com.pandawork.home.common.exception.ChException;
import com.pandawork.home.mapper.system.PowerMapper;
import com.pandawork.home.service.system.PowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Taoyongpan on 2017/8/13.
 */
@Service(value = "powerService")
public class PowerServiceImpl implements PowerService {

    @Autowired
    PowerMapper powerMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SSException.class,Exception.class, RuntimeException.class})
    public void addPower(Power power) throws Exception {
        try{
            if (Assert.isNull(power)){
                return;
            }
            powerMapper.addPower(power);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.AddPowerFailed);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SSException.class,Exception.class, RuntimeException.class})
    public boolean delPower(int id) throws Exception {
        try{
            if (Assert.isNull(id)){
                return false;
            }
            return powerMapper.delPower(id);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.DelPowerFailed);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SSException.class,Exception.class, RuntimeException.class})
    public void updatePower(Power power) throws Exception {
        try{
            if (Assert.isNull(power)){
                return;
            }
            powerMapper.updatePower(power);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.UpdatePowerFailed);
        }
    }

    @Override
    public Power queryById(int id) throws Exception {
        try{
            if (Assert.isNull(id)){
                return null;
            }
            return powerMapper.queryById(id);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.QueryPowerByIdFailed);
        }
    }

    @Override
    public Power queryByPower(int power) throws Exception {
        try{
            if (Assert.isNull(power)){
                return null;
            }
            return powerMapper.queryByPower(power);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.QueryPowerByPowerFailed);
        }
    }

    @Override
    public List<Power> listAll() throws Exception {
        try{
            return powerMapper.listAll();
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.ListAllPowerFailed);
        }
    }
}
