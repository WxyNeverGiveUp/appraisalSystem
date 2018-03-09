package com.pandawork.home.service.check;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.home.common.entity.check.WorkPlan;

import java.util.List;

/**
 * Created by Taoyongpan on 2017/8/29.
 */
public interface WorkPlanService {
    /**
     * 新增工作计划
     * @param workPlan
     * @throws SSException
     */
    public void addWorkPlan(WorkPlan workPlan)throws SSException;

    /**
     * 更新工作计划
     * @param workPlan
     * @throws SSException
     */
    public void updateWorkPlan(WorkPlan workPlan)throws SSException;

    /**
     * 根据用户 ID查找用户的工作计划
     * @param uid
     * @return
     * @throws SSException
     */
    public List<WorkPlan> queryByUid(int uid)throws SSException;

    /**
     * 根据考核计划ID查找工作计划
     * @param testId
     * @return
     * @throws SSException
     */
    public WorkPlan queryByTestId(int testId)throws SSException;

    /**
     * 根据ID查找
     * @param id
     * @return
     * @throws SSException
     */
    public WorkPlan queryById(int id)throws SSException;

    /**
     * 根据被考核用户的ID和测试计划ID查询
     * @param beCheckId
     * @param testId
     * @return
     * @throws SSException
     */
    public WorkPlan queryByTidAndUid(int beCheckId,int testId)throws SSException;

    /**
     * 根据被考核用户ID和年份查找
     * @param beCheckId
     * @param year
     * @return
     * @throws SSException
     */
    public List<WorkPlan> queryByUidAndYear(int beCheckId,int year)throws SSException;

    public List<WorkPlan> listAll()throws SSException;

    /**
     * 根据年份查询
     * @param year
     * @return
     * @throws SSException
     */
    public List<WorkPlan> queryByYear(int year)throws SSException;

    /**
     * 根据被考核用户ID和考核计划ID
     * @param beCheckId
     * @param testId
     * @return
     * @throws SSException
     */
    public boolean delWorkPlan(int beCheckId,int testId)throws SSException;

}
