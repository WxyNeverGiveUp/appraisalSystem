package com.pandawork.home.mapper.check;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.home.common.entity.check.WorkPlan;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Taoyongpan on 2017/8/29.
 */
public interface WorkPlanMapper {

    /**
     * 新增工作计划
     * @param workPlan
     * @throws SSException
     */
    public void addWorkPlan(@Param("workPlan") WorkPlan workPlan)throws SSException;

    /**
     * 更新工作计划
     * @param workPlan
     * @throws SSException
     */
    public void updateWorkPlan(@Param("workPlan") WorkPlan workPlan)throws SSException;

    /**
     * 根据用户ID查找出对应的工作计划
     * @param uid
     * @return
     * @throws SSException
     */
    public List<WorkPlan> queryByUid(@Param("uid") int uid)throws SSException;

    /**
     * 根据考核计划ID找出对应的工作计划
     * @param testId
     * @return
     * @throws SSException
     */
    public WorkPlan queryByTestId(@Param("testId") int testId)throws SSException;

    /**
     * 根据ID查找
     * @param id
     * @return
     * @throws SSException
     */
    public WorkPlan queryById(@Param("id") int id)throws SSException;

    /**
     * 根据被考核用户的ID和测试计划ID查询
     * @param beCheckId
     * @param testId
     * @return
     * @throws SSException
     */
    public WorkPlan queryByTidAndUid(@Param("beCheckId") int beCheckId,@Param("testId") int testId)throws SSException;

    /**
     * 根据被考核用户ID和年份查找
     * @param beCheckId
     * @param year
     * @return
     * @throws SSException
     */
    public List<WorkPlan> queryByUidAndYear(@Param("beCheckId") int beCheckId,@Param("year") int year)throws SSException;

    public List<WorkPlan> listAll()throws SSException;

    /**
     *根据年份查询
     * @param year
     * @return
     * @throws SSException
     */
    public List<WorkPlan> queryByYear(@Param("year") int year)throws SSException;

    /**
     * 根据被考核用户ID和考核计划ID
     * @param beCheckId
     * @param testId
     * @return
     * @throws SSException
     */
    public boolean delWorkPlan(@Param("beCheckId")int beCheckId,@Param("testId") int testId)throws SSException;
}
