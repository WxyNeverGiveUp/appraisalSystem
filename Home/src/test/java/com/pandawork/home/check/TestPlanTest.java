package com.pandawork.home.check;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.home.AbstractTestCase;
import com.pandawork.home.common.entity.check.TestPlan;
import com.pandawork.home.service.check.TestPlanService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Taoyongpan on 2017/8/28.
 */
public class TestPlanTest extends AbstractTestCase {
    @Autowired
    TestPlanService testPlanService;

    /**
     * 新增考核计划
     * @throws Exception
     */
    @Test
    public void testAddTestPlan()throws Exception{
        TestPlan testPlan = new TestPlan();
        testPlan.setUid(1);
        testPlan.setTestTypeId(1);
        testPlan.setStartTime("2017-08-28");
        testPlan.setFinishTime("2017-10-01");
        testPlan.setTestName("月度考核");
        testPlanService.addTestPlan(testPlan);
    }

    /**
     * 更新考核计划
     * @throws Exception
     */
    @Test
    public void testUpdateTestPlan()throws Exception{
        TestPlan testPlan = new TestPlan();
        testPlan.setId(1);
        testPlan.setUid(2);
        testPlan.setTestTypeId(1);
        testPlan.setStartTime("2017-08-28");
        testPlan.setFinishTime("2017-10-01");
        testPlan.setTestName("月度考核");
        testPlanService.updateTestPlan(testPlan);
    }

    /**
     * 删除考核计划
     * @throws Exception
     */
    @Test
    public void testDelTestPlan()throws Exception{
        TestPlan testPlan = new TestPlan();
        testPlan.setIsAvailable(0);
        testPlan.setId(1);
        testPlanService.delTestPlan(testPlan);
    }

    /**
     * 根据 ID删除考核计划
     * @throws Exception
     */
    @Test
    public void testQueryById()throws Exception{
        testPlanService.queryTestPlan(1);
    }

    /**
     * 列出所有考核计划类型
     * @throws Exception
     */
    @Test
    public void testListAll()throws Exception{
        testPlanService.listAll();
    }

    /**
     * 计算总数
     * @throws Exception
     */
    @Test
    public void testCountAll()throws Exception{
        testPlanService.countAll();
    }

    @Test
    public void testQueryByUid()throws SSException{
        testPlanService.queryByUid(7);
    }
}
