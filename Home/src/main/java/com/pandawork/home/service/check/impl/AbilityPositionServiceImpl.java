package com.pandawork.home.service.check.impl;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.core.common.log.LogClerk;
import com.pandawork.core.common.util.Assert;
import com.pandawork.home.common.entity.check.AbilityPosition;
import com.pandawork.home.common.exception.ChException;
import com.pandawork.home.mapper.check.AbilityPositionMapper;
import com.pandawork.home.service.check.AbilityPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Taoyongpan on 2017/8/31.
 */
@Service(value = "abilityPositionService")
public class AbilityPositionServiceImpl implements AbilityPositionService {
    @Autowired
    AbilityPositionMapper abilityPositionMapper;
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SSException.class,Exception.class, RuntimeException.class})
    public void addPosition(AbilityPosition abilityPosition) throws SSException {
        try{
            if (Assert.isNull(abilityPosition)){
                return;
            }
            abilityPositionMapper.addPosition(abilityPosition);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.AddPositionFailed);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SSException.class,Exception.class, RuntimeException.class})
    public void delPosition(AbilityPosition abilityPosition) throws SSException {
        try{
            if (Assert.isNull(abilityPosition)){
                return;
            }
            abilityPositionMapper.delPosition(abilityPosition);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.DelPositionFailed);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SSException.class,Exception.class, RuntimeException.class})
    public void updatePosition(AbilityPosition abilityPosition) throws SSException {
        try{
            if (Assert.isNull(abilityPosition)){
                return;
            }
            abilityPositionMapper.updatePosition(abilityPosition);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.UpdatePositionFailed);
        }
    }

    @Override
    public List<AbilityPosition> queryByDid(int did) throws SSException {
        try{
            if (Assert.isNull(did)){
                return null;
            }
            return abilityPositionMapper.queryByDid(did);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.QueryPositionByDidFailed);
        }
    }

    @Override
    public int countAll() throws SSException {
        try{
            return abilityPositionMapper.countAll();
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.CountAllPositionFailed);
        }
    }

    @Override
    public List<AbilityPosition> queryByTestId(int testId) throws SSException {
        try {
            if (Assert.isNull(testId)){
                return null;
            }
            return abilityPositionMapper.queryByTestId(testId);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.QueryPositionByDidFailed);
        }
    }

    @Override
    public AbilityPosition queryById(int id) throws SSException {
        try {
            if (Assert.isNull(id)){
                return null;
            }
            return abilityPositionMapper.queryById(id);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.QueryPositionByDidFailed);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SSException.class,Exception.class, RuntimeException.class})
    public boolean del(int id) throws SSException {
        try {
            if (Assert.isNull(id)){
                return false;
            }
            return abilityPositionMapper.del(id);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.DelPositionFailed);
        }
    }

    @Override
    public AbilityPosition queryByCondition(AbilityPosition abilityPosition) throws SSException {
        try {
            if (Assert.isNull(abilityPosition)){
                return null;
            }
            return abilityPositionMapper.queryByCondition(abilityPosition);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.QueryPositionByDidFailed);
        }
    }
}
