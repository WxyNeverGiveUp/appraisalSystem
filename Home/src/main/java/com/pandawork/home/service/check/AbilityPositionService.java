package com.pandawork.home.service.check;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.home.common.entity.check.AbilityPosition;

import java.util.List;

/**
 * Created by Taoyongpan on 2017/8/31.
 */
public interface AbilityPositionService {

    /**
     * 新增问题
     * @param abilityPosition
     * @throws SSException
     */
    public void addPosition(AbilityPosition abilityPosition)throws SSException;

    /**
     * 删除问题
     * @param abilityPosition
     * @throws SSException
     */
    public void delPosition(AbilityPosition abilityPosition)throws SSException;

    /**
     * 编辑问题
     * @param abilityPosition
     * @throws SSException
     */
    public void updatePosition(AbilityPosition abilityPosition)throws SSException;

    /**
     * 根据部门ID列出所有问题
     * @param did
     * @return
     * @throws SSException
     */
    public List<AbilityPosition> queryByDid(int did)throws SSException;

    /**
     * 计算所有的条数
     * @return
     * @throws SSException
     */
    public int countAll()throws SSException;

    /**
     * 根据考核计划ID查找问题
     * @param testId
     * @return
     * @throws SSException
     */
    public List<AbilityPosition> queryByTestId(int testId)throws SSException;

    /**
     * 根据ID查找问题
     * @param id
     * @return
     * @throws SSException
     */
    public AbilityPosition queryById(int id)throws SSException;

    /**
     * 根据ID删除
     * @param id
     * @return
     * @throws SSException
     */
    public boolean del(int id)throws SSException;

    /**
     * 根据 多条件查询ID
     * @param abilityPosition
     * @return
     * @throws SSException
     */
    public AbilityPosition queryByCondition(AbilityPosition abilityPosition)throws SSException;

}
