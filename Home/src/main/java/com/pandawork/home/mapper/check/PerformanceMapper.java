package com.pandawork.home.mapper.check;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.home.common.entity.check.Performance;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Taoyongpan on 2017/8/30.
 */
public interface PerformanceMapper {
    /**
     * 新增工作计划成绩
     * @param performance
     * @throws SSException
     */
    public void addPerformance(@Param("performance") Performance performance)throws SSException;

    /**
     * 编辑工作计划成绩
     * @param performance
     * @throws SSException
     */
    public void updateSummaryScore(@Param("performance") Performance performance)throws SSException;

    /**
     * 年度打分
     * @param performance
     * @throws SSException
     */
    public void updateYearScore(@Param("performance") Performance performance)throws SSException;
    /**
     * 根据ID删除工作计划
     * @param id
     * @return
     * @throws SSException
     */
    public boolean delPerformance(@Param("id") int id)throws SSException;

    /**
     * 根据年份和月份查找
     * @param year
     * @param month
     * @return
     * @throws SSException
     */
    public List<Performance> queryByYearAndMonth(@Param("year") int year,@Param("month") int month)throws SSException;

    /**
     * 根据年份和季度查找
     * @param year
     * @param queater
     * @return
     * @throws SSException
     */
    public List<Performance> queryByYearAndQueater(@Param("year") int year,@Param("queater") int queater)throws SSException;

    /**
     * 计算总条数
     * @return
     * @throws SSException
     */
    public int countAll()throws SSException;

    /**
     * 根据部门ID查找
     * @param did
     * @return
     * @throws SSException
     */
    public List<Performance> queryByDid(@Param("did") int did)throws SSException;

    /**
     * 根据被考核用户的ID查找
     * @param beCheckId
     * @return
     * @throws SSException
     */
    public List<Performance> queryByUid(@Param("beCheckId") int beCheckId)throws SSException;

    /**
     * 根据被考核用户ID查找年份列表
     * @param beCheckId
     * @return
     * @throws SSException
     */
    public List<Performance> queryYearByUid(@Param("beCheckId") int beCheckId)throws SSException;

    /**
     * 列出所有
     * @return
     * @throws SSException
     */
    public List<Performance> listAll()throws SSException;

    /**
     * 根据被考核用户DI和年份查询
     * @param beCheckId
     * @param year
     * @return
     * @throws SSException
     */
    public Performance queryByUidAndYear(@Param("beCheckId") int beCheckId,@Param("year") int year)throws SSException;

    /**
     * 根据年份查找
     * @param year
     * @return
     * @throws SSException
     */
    public List<Performance> queryByYear(@Param("year") int year)throws SSException;

}
