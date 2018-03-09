package com.pandawork.home.mapper.check;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.home.common.entity.check.AbilityTarget;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Taoyongpan on 2017/8/31.
 */
public interface AbilityTargetMapper {

    /**
     * 增加能力指标考核指标
     * @throws SSException
     */
    public void addTarget(@Param("abilityTarget") AbilityTarget abilityTarget)throws SSException;

    /**
     * 删除能力指标考核指标
     * @return
     * @throws SSException
     */
    public boolean delTarget(@Param("id") int id)throws SSException;

    /**
     * 更新能力指标考核指标
     * @throws SSException
     */
    public void updateTarget(@Param("abilityTarget") AbilityTarget abilityTarget)throws SSException;

    /**
     * 列出全部
     * @return
     * @throws SSException
     */
    public List<AbilityTarget> listAll()throws SSException;
}
