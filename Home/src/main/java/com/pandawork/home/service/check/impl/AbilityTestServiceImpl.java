package com.pandawork.home.service.check.impl;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.core.common.log.LogClerk;
import com.pandawork.core.common.util.Assert;
import com.pandawork.home.common.entity.check.AbilityTest;
import com.pandawork.home.common.exception.ChException;
import com.pandawork.home.mapper.check.AbilityTestMapper;
import com.pandawork.home.service.check.AbilityTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Taoyongpan on 2017/9/23.
 */
@Service(value = "abilityTestService")
public class AbilityTestServiceImpl implements AbilityTestService {

    @Autowired
    AbilityTestMapper abilityTestMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SSException.class,Exception.class, RuntimeException.class})
    public void addAbilityTest(AbilityTest abilityTest) throws SSException {
        try {
            if (Assert.isNull(abilityTest)){
                return;
            }
            abilityTestMapper.addAbilityTest(abilityTest);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.AddAbilityTest);
        }
    }

    @Override
    public List<AbilityTest> queryByTestIdAndUid(int testId, int beCheckId) throws SSException {
        try {
            if (Assert.isNull(testId)||Assert.isNull(beCheckId)){
                return null;
            }
            return abilityTestMapper.queryByTestIdAndUid(testId,beCheckId);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.QueryAbilityTestByTidAndUid);
        }
    }

    @Override
    public AbilityTest queryByTidAndUid(int tid, int uid) throws SSException {
        try {
            if (Assert.isNull(tid)||Assert.isNull(uid)){
                return null;
            }
            return abilityTestMapper.queryByTidAndUid(tid,uid);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.QueryAbilityTestByTidAndUid);
        }
    }

    @Override
    public void updateScore(AbilityTest abilityTest) throws SSException {
        try {
            if (Assert.isNull(abilityTest)){
                return;
            }
            abilityTestMapper.updateScore(abilityTest);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.AddAbilityTest);
        }
    }

    @Override
    public boolean delByTidAndUid(int testId, int beCheckId) throws SSException {
        try {
            if (Assert.isNull(testId)||Assert.isNull(beCheckId)){
                return false;
            }
            return abilityTestMapper.delByTidAndUid(testId, beCheckId);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.AddAbilityTest);
        }
    }

    @Override
    public List<AbilityTest> queryByTid(int tid) throws SSException {
        try {
            if (Assert.isNull(tid)){
                return null;
            }
            return abilityTestMapper.queryByTid(tid);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.QueryAbilityTestByTidAndUid);
        }
    }
}
