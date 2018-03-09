package com.pandawork.home.service.check.impl;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.core.common.log.LogClerk;
import com.pandawork.core.common.util.Assert;
import com.pandawork.home.common.entity.check.AbilityTargetType;
import com.pandawork.home.common.exception.ChException;
import com.pandawork.home.mapper.check.AbilityTargetTypeMapper;
import com.pandawork.home.service.check.AbilityTargetTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Taoyongpan on 2017/8/31.
 */
@Service(value = "abilityTargetTypeService")
public class AbilityTargetTypeServiceImpl implements AbilityTargetTypeService {
    @Autowired
    AbilityTargetTypeMapper abilityTargetTypeMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SSException.class,Exception.class, RuntimeException.class})
    public void addTargetType(AbilityTargetType abilityTargetType) throws SSException {
        try{
            if (Assert.isNull(abilityTargetType)){
                return;
            }
            abilityTargetTypeMapper.addTargetType(abilityTargetType);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.AddAbilityTargetTypeFailed);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SSException.class,Exception.class, RuntimeException.class})
    public boolean delTargetType(int id) throws SSException {
        try{
            if (Assert.isNull(id)){
                return false;
            }
            return abilityTargetTypeMapper.delTargetType(id);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.DelAbilityTargetTypeFailed);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SSException.class,Exception.class, RuntimeException.class})
    public void updateTargetType(AbilityTargetType abilityTargetType) throws SSException {
        try{
            if (Assert.isNull(abilityTargetType)){
                return;
            }
            abilityTargetTypeMapper.updateTargetType(abilityTargetType);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.UpdateAbilityTargetTypeFailed);
        }
    }

    @Override
    public List<AbilityTargetType> listAll() throws SSException {
        try{
            return abilityTargetTypeMapper.listAll();
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.ListTargetTypeFailed);
        }
    }
}
