package com.pandawork.home.check;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.home.AbstractTestCase;
import com.pandawork.home.common.entity.check.Performance;
import com.pandawork.home.service.check.PerformanceService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Taoyongpan on 2017/9/3.
 */
public class PerformnceTest extends AbstractTestCase {

    @Autowired
    PerformanceService performanceService;

    /**
     * 新增测试
     * @throws SSException
     */
    @Test
    public void addPerformance()throws SSException{
        Performance performance = new Performance();
        performance.setBeCheckId(1);
        performance.setYear(2017);
        performance.setQueater(2);
        performance.setMonth(2);
        performance.setSuggestScore(23.2);
        performanceService.addPerformance(performance);
    }

    /**
     * 年度总结打分
     * @throws SSException
     */
    @Test
    public void updateSummaryScore()throws SSException{
        Performance performance = new Performance();
        performance.setId(1);
        performance.setSummaryScore(23.1);
        performance.setBeCheckId(1);
        performanceService.updateSummaryScore(performance);
    }

    /**
     * 年度 打分
     * @throws SSException
     */
    @Test
    public void updateYearScore()throws SSException{
        Performance performance = new Performance();
        performance.setYearScore(23.5);
        performance.setId(1);
        performanceService.updateYearScore(performance);
    }

    /**
     * 删除测试
     * @throws SSException
     */
    @Test
    public void del()throws SSException{
        performanceService.delPerformance(2);
    }

    /**
     * 根据年份和季度 查找
     * @throws SSException
     */
    @Test
    public void queryByYAQ()throws SSException{
        performanceService.queryByYearAndQueater(2017,2);
    }

    /**
     * 根据年份和月份查找
     * @throws SSException
     */
    @Test
    public void queryByQAM()throws SSException{
        performanceService.queryByYearAndMonth(2017,2);
    }


    @Test
    public void countAll()throws SSException{
        performanceService.countAll();
    }

    /**
     * 根据部门ID查找
     * @throws SSException
     */
    @Test
    public void queryByDid()throws SSException{
        performanceService.queryByDid(1);
    }
}
