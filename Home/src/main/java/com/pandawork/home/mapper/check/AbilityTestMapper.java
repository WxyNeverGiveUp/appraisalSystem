package com.pandawork.home.mapper.check;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.home.common.entity.check.AbilityTest;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Taoyongpan on 2017/9/23.
 */
public interface AbilityTestMapper {

    /**
     * 新增能力指标
     * @param abilityTest
     * @throws SSException
     */
    public void addAbilityTest(@Param("abilityTest") AbilityTest abilityTest)throws SSException;

    /**
     * 根据考核用户的ID和考核计划的ID查找
     * @param testId
     * @param beCheckId
     * @return
     * @throws SSException
     */
    public List<AbilityTest> queryByTestIdAndUid(@Param("testId") int testId, @Param("CheckId") int beCheckId)throws SSException;

    /**
     * 根据考核计划ID和考核者的ID查询
     * @param tid
     * @param uid
     * @return
     * @throws SSException
     */
    public AbilityTest queryByTidAndUid(@Param("tid") int tid,@Param("uid") int uid)throws SSException;

    /**
     * 打分
     * @param abilityTest
     * @throws SSException
     */
    public void updateScore(@Param("abilityTest") AbilityTest abilityTest)throws SSException;

    /**
     * 根据考核计划ID和被考核用户ID删除
     * @param testId
     * @param beCheckId
     * @return
     * @throws SSException
     */
    public boolean delByTidAndUid(@Param("testId") int testId,@Param("beCheckId") int beCheckId)throws SSException;

    /**
     * 根据考核计划ID查询
     * @param tid
     * @return
     * @throws SSException
     */
    public List<AbilityTest> queryByTid(@Param("tid") int tid)throws SSException;
}
