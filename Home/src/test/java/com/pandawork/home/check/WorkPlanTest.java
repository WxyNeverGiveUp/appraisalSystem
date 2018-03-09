package com.pandawork.home.check;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.home.AbstractTestCase;
import com.pandawork.home.common.entity.check.WorkPlan;
import com.pandawork.home.service.check.WorkPlanService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Taoyongpan on 2017/8/29.
 */
public class WorkPlanTest extends AbstractTestCase {
    @Autowired
    WorkPlanService workPlanService;

    @Test
    public void testAdd()throws SSException{
        WorkPlan workPlan = new WorkPlan();

    }

    @Test
    public void testUpdate()throws SSException{
        WorkPlan workPlan = new WorkPlan();

    }
}
