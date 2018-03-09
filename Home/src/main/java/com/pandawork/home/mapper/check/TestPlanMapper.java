package com.pandawork.home.mapper.check;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.home.common.dto.AllotDto;
import com.pandawork.home.common.entity.check.TestPlan;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Taoyongpan on 2017/8/28.
 */
public interface TestPlanMapper {
    /**
     * 添加考核计划
     * @param testPlan
     * @throws SSException
     */
    public void addTestPlan(@Param("testPlan") TestPlan testPlan)throws SSException;

    /**
     * 修改考核计划
     * @param testPlan
     * @throws SSException
     */
    public void updateTestPlan(@Param("testPlan")TestPlan testPlan)throws SSException;

    /**
     * 删除考核计划
     * @param testPlan
     * @throws SSException
     */
    public void delTestPlan(@Param("testPlan")TestPlan testPlan)throws SSException;

    /**
     * 根据ID查找考核计划
     * @param id
     * @return
     * @throws SSException
     */
    public TestPlan queryById(@Param("id")int id)throws SSException;

    /**
     * 列出所有的考核计划类型
     * @return
     * @throws SSException
     */
    public List<TestPlan> listAll()throws SSException;

    /**
     * 计算考核计划的总数
     * @return
     * @throws SSException
     */
    public int countAll()throws SSException;

    /**
     * 根据用户ID查找考核计划
     * @param uid
     * @return
     * @throws SSException
     */
    public List<TestPlan> queryByUid(@Param("uid") int uid)throws SSException;

    /**
     * 根据部门ID查找
     * @param did
     * @return
     * @throws SSException
     */
    public List<TestPlan> queryByDid(@Param("did") int did)throws SSException;

    /**
     * 根据用户ID和考核类型ID查找
     * @param uid
     * @param testTypeId
     * @return
     * @throws SSException
     */
    public List<TestPlan> queryByUidAndTypeId(@Param("uid") int uid,@Param("testTypeId") int testTypeId)throws SSException;

    /**
     * 根据考核类型查找考核计划
     * @param testTypeId
     * @return
     * @throws SSException
     */
    public List<TestPlan> queryByTypeId(@Param("testTypeId") int testTypeId)throws SSException;

    /**
     * 列出所有的用户
     * @return
     * @throws SSException
     */
    public List<AllotDto> listAllUser()throws SSException;

    /**
     * 根据ID删除
     * @param id
     * @return
     * @throws SSException
     */
    public boolean del(@Param("id") int id)throws SSException;

    /**
     * 根据部门ID查找
     * @param did
     * @return
     * @throws SSException
     */
    public List<AllotDto> queryAllotDaoByDid(@Param("did") int did)throws SSException;
}
