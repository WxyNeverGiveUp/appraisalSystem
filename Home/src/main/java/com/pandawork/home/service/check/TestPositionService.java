package com.pandawork.home.service.check;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.home.common.dto.TestPositionDto;
import com.pandawork.home.common.entity.check.TestPosition;

import java.util.List;

/**
 * Created by Taoyongpan on 2017/9/14.
 */
public interface TestPositionService {

    /**
     * 新增
     * @param testPosition
     * @throws SSException
     */
    public void addTestPosition(TestPosition testPosition)throws SSException;

    /**
     * 根据ID删除
     * @param id
     * @return
     * @throws SSException
     */
    public boolean delTestPosition(int id)throws SSException;

    /**
     * 根据考核计划的ID查询
     * @param testId
     * @return
     * @throws SSException
     */
    public List<TestPosition> queryByTestId(int testId)throws SSException;

    /**
     * 根据考核计划ID查找DTO
     * @param testId
     * @return
     * @throws SSException
     */
    public List<TestPositionDto> queryDtoByTesId(int testId)throws SSException;
}
