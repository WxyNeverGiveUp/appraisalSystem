package com.pandawork.home.service.check.impl;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.core.common.log.LogClerk;
import com.pandawork.core.common.util.Assert;
import com.pandawork.home.common.entity.check.AbilityOption;
import com.pandawork.home.common.exception.ChException;
import com.pandawork.home.mapper.check.AbilityOptionMapper;
import com.pandawork.home.service.check.AbilityOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Taoyongpan on 2017/8/31.
 */
@Service(value = "abilityOptionService")
public class AbilityOptionServiceImpl implements AbilityOptionService {
    @Autowired
    AbilityOptionMapper abilityOptionMapper;


    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SSException.class,Exception.class, RuntimeException.class})
    public void addOption(AbilityOption abilityOption) throws SSException {
        try{
            if (Assert.isNull(abilityOption)){
                return;
            }
            abilityOptionMapper.addOption(abilityOption);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.AddOptionFailed);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SSException.class,Exception.class, RuntimeException.class})
    public boolean delOption(int id) throws SSException {
        try{
            if (Assert.isNull(id)){
                return false;
            }
            return abilityOptionMapper.delOption(id);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.DelOptionFailed);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SSException.class,Exception.class, RuntimeException.class})
    public void updateOption(AbilityOption abilityOption) throws SSException {
        try {
            if (Assert.isNull(abilityOption)){
                return;
            }
            abilityOptionMapper.updateOption(abilityOption);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.UpdateOptionFailed);
        }
    }

    @Override
    public List<AbilityOption> queryByPositionId(int positionId) throws SSException {
        try{
            if (Assert.isNull(positionId)){
                return null;
            }
            return abilityOptionMapper.queryByPositionId(positionId);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.QueryOptionByPositionId);
        }
    }

    @Override
    public List<AbilityOption> queryByTestId(int testId) throws SSException {
        try {
            if (Assert.isNull(testId)){
                return null;
            }
            return abilityOptionMapper.queryByTestId(testId);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.QueryOptionByPositionId);
        }
    }

    @Override
    public AbilityOption queryByPidAndOption(int positionId, int optionName) throws SSException {
        try {
            if (Assert.isNull(positionId)||Assert.isNull(optionName)){
                return null;
            }
            return abilityOptionMapper.queryByPidAndOption(positionId,optionName);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.QueryOptionByPositionId);
        }
    }
}
