package com.pandawork.home.service.check.impl;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.core.common.log.LogClerk;
import com.pandawork.core.common.util.Assert;
import com.pandawork.home.common.entity.check.AbilityTarget;
import com.pandawork.home.common.exception.ChException;
import com.pandawork.home.mapper.check.AbilityTargetMapper;
import com.pandawork.home.service.check.AbilityTargetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Taoyongpan on 2017/8/31.
 */
@Service(value = "abilityTargetService")
public class AbilityTargetServiceImpl implements AbilityTargetService {
    @Autowired
    AbilityTargetMapper abilityTargetMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SSException.class,Exception.class, RuntimeException.class})
    public void addTarget(AbilityTarget abilityTarget) throws SSException {
        try{
            if (Assert.isNull(abilityTarget)){
                return;
            }
            abilityTargetMapper.addTarget(abilityTarget);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.AddAbilityTargetFailed);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SSException.class,Exception.class, RuntimeException.class})
    public boolean delTarget(int id) throws SSException {
        try{
            if (Assert.isNull(id)){
                return false;
            }
            return abilityTargetMapper.delTarget(id);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.DelAbilityTargetFailed);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SSException.class,Exception.class, RuntimeException.class})
    public void updateTarget(AbilityTarget abilityTarget) throws SSException {
        try{
            if (Assert.isNull(abilityTarget)){
                return;
            }
            abilityTargetMapper.updateTarget(abilityTarget);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.UpdateAbilityTarget);
        }
    }

    @Override
    public List<AbilityTarget> listAll() throws SSException {
        try{
            return abilityTargetMapper.listAll();
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.ListTargetFailed);
        }
    }
}
