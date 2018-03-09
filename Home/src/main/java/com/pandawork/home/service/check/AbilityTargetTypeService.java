package com.pandawork.home.service.check;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.home.common.entity.check.AbilityTargetType;

import java.util.List;

/**
 * Created by Taoyongpan on 2017/8/31.
 */
public interface AbilityTargetTypeService {
    /**
     * 新增能力指标类型
     * @param abilityTargetType
     * @throws SSException
     */
    public void addTargetType(AbilityTargetType abilityTargetType)throws SSException;

    /**
     * 删除
     * @param id
     * @return
     * @throws SSException
     */
    public boolean delTargetType(int id)throws SSException;

    /**
     * 更新
     * @param abilityTargetType
     * @throws SSException
     */
    public void updateTargetType(AbilityTargetType abilityTargetType)throws SSException;

    /**
     * 列出所有类型
     * @return
     * @throws SSException
     */
    public List<AbilityTargetType> listAll()throws SSException;
}
