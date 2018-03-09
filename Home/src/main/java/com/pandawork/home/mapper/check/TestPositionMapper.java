package com.pandawork.home.mapper.check;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.home.common.dto.TestPositionDto;
import com.pandawork.home.common.entity.check.TestPosition;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Taoyongpan on 2017/9/14.
 */
public interface TestPositionMapper {
    /**
     * 新增
     * @param testPosition
     * @throws SSException
     */
    public void addTestPosition(@Param("testPosition") TestPosition testPosition)throws SSException;

    /**
     * 根据ID删除
     * @param id
     * @return
     * @throws SSException
     */
    public boolean delTestPosition(@Param("id") int id)throws SSException;

    /**
     * 根据考核计划的ID查询
     * @param testId
     * @return
     * @throws SSException
     */
    public List<TestPosition> queryByTestId(@Param("testId") int testId)throws SSException;

    /**
     * 根据考核计划ID查找DTO
     * @param testId
     * @return
     * @throws SSException
     */
    public List<TestPositionDto> queryDtoByTestId(@Param("testId") int testId)throws SSException;
}
