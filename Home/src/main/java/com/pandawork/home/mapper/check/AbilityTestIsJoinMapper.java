package com.pandawork.home.mapper.check;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.home.common.entity.check.AbilityTestIsJoin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Taoyongpan on 2017/9/26.
 */
public interface AbilityTestIsJoinMapper {

    public void addAbilityIsJoin(@Param("abilityTestIsJoin") AbilityTestIsJoin abilityTestIsJoin)throws SSException;


    public AbilityTestIsJoin queryByTidAndUid(@Param("testId") int testId,@Param("uid") int uid,@Param("checkId") int checkId)throws SSException;

    public List<AbilityTestIsJoin> queryByTid(@Param("testId") int testId)throws SSException;
}
