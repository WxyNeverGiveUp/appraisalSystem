package com.pandawork.home.service.check;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.home.common.entity.check.TestType;

import java.util.List;

/**
 * Created by Taoyongpan on 2017/8/29.
 */
public interface TestTypeService
{
    /**
     * 新增考核计划类别
     * @param testType
     * @throws SSException
     */
    public void addTestType(TestType testType)throws SSException;

    /**
     * 根据ID删除考核计划类别
     * @param id
     * @return
     * @throws SSException
     */
    public boolean delTestType(int id) throws SSException;

    /**
     * 更新考核计划类别
     * @param testType
     * @throws SSException
     */
    public void updateTestType(TestType testType)throws SSException;

    /**
     * 列出所有的考核计划类别
     * @return
     * @throws SSException
     */
    public List<TestType> listAll()throws SSException;
}
