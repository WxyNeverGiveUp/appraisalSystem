package com.pandawork.home.mapper.check;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.home.common.entity.check.TestType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Taoyongpan on 2017/8/28.
 */
public interface TestTypeMapper {

    /**
     * 新增考核计划类型
     * @param testType
     * @throws SSException
     */
    public void addTestType(@Param("testType") TestType testType)throws SSException;

    /**
     * 删除考核计划类型
     * @param id
     * @throws SSException
     */
    public boolean delTestType(@Param("id")int id)throws SSException;

    /**
     * 更新考核计划类型
     * @param testType
     * @throws SSException
     */
    public void updateTestType(@Param("testType")TestType testType)throws SSException;

    /**
     * 列出所有的考核类型
     * @return
     * @throws SSException
     */
    public List<TestType> listAll()throws SSException;

}
