package com.pandawork.home.mapper.check;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.home.common.entity.check.AbilityOption;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Taoyongpan on 2017/8/31.
 */
public interface AbilityOptionMapper {
    /**
     * 新增选项
     * @param abilityOption
     * @throws SSException
     */
    public void addOption(@Param("abilityOption") AbilityOption abilityOption)throws SSException;

    /**
     * 删除选项
     * @param id
     * @return
     * @throws SSException
     */
    public boolean delOption(@Param("id") int id)throws SSException;

    /**
     * 编辑选项信息
     * @param abilityOption
     * @throws SSException
     */
    public void updateOption(@Param("abilityOption") AbilityOption abilityOption)throws SSException;

    /**
     * 根据问题ID查出该问题的所有选项
     * @param positionId
     * @throws SSException
     */
    public List<AbilityOption> queryByPositionId(@Param("positionId") int positionId)throws SSException;

    /**
     * 根据考核计划ID查找选项
     * @param testId
     * @return
     * @throws SSException
     */
    public List<AbilityOption> queryByTestId(@Param("testId") int testId)throws SSException;

    /**
     * 根据问题ID和问题选项
     * @param positionId
     * @param optionName
     * @return
     * @throws SSException
     */
    public AbilityOption queryByPidAndOption(@Param("positionId") int positionId,@Param("optionName") int optionName)throws SSException;
}
