package com.pandawork.home.service.check.impl;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.core.common.log.LogClerk;
import com.pandawork.core.common.util.Assert;
import com.pandawork.home.common.entity.check.AbilityResult;
import com.pandawork.home.common.exception.ChException;
import com.pandawork.home.mapper.check.AbilityResultMapper;
import com.pandawork.home.service.check.AbilityResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Taoyongpan on 2017/9/1.
 */
@Service(value = "abilityResultService")
public class AbilityResultServiceImpl implements AbilityResultService {
    @Autowired
    AbilityResultMapper abilityResultMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SSException.class,Exception.class, RuntimeException.class})
    public void addResult(AbilityResult abilityResult) throws SSException {
        try{
            if (Assert.isNull(abilityResult)){
                return;
            }
            abilityResultMapper.addResult(abilityResult);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.AddResultFailed);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SSException.class,Exception.class, RuntimeException.class})
    public void updateResult(AbilityResult abilityResult) throws SSException {
        try {
            if (Assert.isNull(abilityResult)){
                return;
            }
            abilityResultMapper.updateResult(abilityResult);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.UpdateResultFailed);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SSException.class,Exception.class, RuntimeException.class})
    public boolean delResult(int id) throws SSException {
        try{
            if (Assert.isNull(id)){
                return false;
            }
            return abilityResultMapper.delResult(id);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.DelResultFailed);
        }
    }

    @Override
    public int coutAll() throws SSException {
        try {
            return abilityResultMapper.countAll();
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.CountAllResultFailed);
        }
    }

    @Override
    public List<AbilityResult> queryByDid(int did) throws SSException {
        try {
            if (Assert.isNull(did)){
                return null;
            }
            return abilityResultMapper.queryByDid(did);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.QueryResultByDidFailed);
        }
    }
    @Override
    public List<AbilityResult> listAll() throws SSException {
        try {
            return abilityResultMapper.listAll();
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.ListAllResultFailed);
        }
    }

    @Override
    public AbilityResult queryByTidAndUid(int testId, int uid) throws SSException {
        try {
            if (Assert.isNull(testId)||Assert.isNull(uid)){
                return null;
            }
            return abilityResultMapper.queryByTidAndUid(testId, uid);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.QueryDepartmentByIdFailed);
        }
    }
}
