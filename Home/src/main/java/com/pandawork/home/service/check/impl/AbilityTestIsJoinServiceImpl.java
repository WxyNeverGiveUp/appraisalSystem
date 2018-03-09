package com.pandawork.home.service.check.impl;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.core.common.log.LogClerk;
import com.pandawork.core.common.util.Assert;
import com.pandawork.home.common.entity.check.AbilityTestIsJoin;
import com.pandawork.home.common.exception.ChException;
import com.pandawork.home.mapper.check.AbilityTestIsJoinMapper;
import com.pandawork.home.service.check.AbilityTestIsJoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Taoyongpan on 2017/9/26.
 */
@Service(value = "abilityTestIsJoinService")
public class AbilityTestIsJoinServiceImpl implements AbilityTestIsJoinService {
    @Autowired
    AbilityTestIsJoinMapper abilityTestIsJoinMapper;

    @Override
    public void addAbilityIsJoin(AbilityTestIsJoin abilityTestIsJoin) throws SSException {
        try {
            if (Assert.isNull(abilityTestIsJoin)){
                return;
            }
            abilityTestIsJoinMapper.addAbilityIsJoin(abilityTestIsJoin);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.QueryAbilityTestByTidAndUid);
        }
    }

    @Override
    public AbilityTestIsJoin queryByTidAndUid(int testId, int uid,int checkId) throws SSException {
        try {
            if (Assert.isNull(testId)||Assert.isNull(uid)){
                return null;
            }
            return abilityTestIsJoinMapper.queryByTidAndUid(testId, uid,checkId);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.QueryAbilityTestByTidAndUid);
        }
    }

    @Override
    public List<AbilityTestIsJoin> queryByTid(int testId) throws SSException {
        try {
            if (Assert.isNull(testId)){
                return null;
            }
            return abilityTestIsJoinMapper.queryByTid(testId);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.ExportFailed);
        }
    }


}
