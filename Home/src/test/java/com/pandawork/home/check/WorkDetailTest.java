package com.pandawork.home.check;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.home.AbstractTestCase;
import com.pandawork.home.common.entity.check.WorkDetail;
import com.pandawork.home.service.check.WorkDetailService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Taoyongpan on 2017/9/3.
 */
public class WorkDetailTest extends AbstractTestCase{

    @Autowired
    WorkDetailService workDetailService;

    /**
     * 新增工作计划详情
     * @throws SSException
     */
    @Test
    public void addWorkDetailTest()throws SSException{
        WorkDetail workDetail = new WorkDetail();
        workDetail.setWid(1);
        workDetail.setStartTime("210170503");
        workDetail.setEndTime("20171212");
        workDetail.setPlanContent("系统开发");
        workDetail.setExpectResult("完成系统开发");
        workDetail.setWeight(20);
        workDetailService.addWorkDetail(workDetail);
    }

    /**
     * 编辑测试
     * @throws SSException
     */
    @Test
    public void editWorkDetailTest()throws SSException{
        WorkDetail workDetail = new WorkDetail();
        workDetail.setId(1);
        workDetail.setWid(1);
        workDetail.setStartTime("20170503");
        workDetail.setEndTime("20171212");
        workDetail.setPlanContent("系统开发");
        workDetail.setExpectResult("完成系统开发");
        workDetail.setWeight(20);
        workDetailService.updateWorkDetail(workDetail);
    }

    @Test
    public void queryByWidTest()throws SSException{
        workDetailService.queryByWId(1);
    }


    @Test
    public void delTest()throws SSException{
        workDetailService.delWorkDetail(1);
    }

}
