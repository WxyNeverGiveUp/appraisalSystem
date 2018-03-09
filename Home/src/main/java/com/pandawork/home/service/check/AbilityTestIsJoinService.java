package com.pandawork.home.service.check;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.home.common.entity.check.AbilityTestIsJoin;

import java.util.List;

/**
 * Created by Taoyongpan on 2017/9/26.
 */
public interface AbilityTestIsJoinService {

    public void addAbilityIsJoin(AbilityTestIsJoin abilityTestIsJoin)throws SSException;


    public AbilityTestIsJoin queryByTidAndUid(int testId,int uid,int checkId)throws SSException;

    public List<AbilityTestIsJoin> queryByTid(int testId)throws SSException;

}
