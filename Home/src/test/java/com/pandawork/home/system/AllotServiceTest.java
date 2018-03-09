package com.pandawork.home.system;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.home.AbstractTestCase;
import com.pandawork.home.common.entity.system.Allot;
import com.pandawork.home.service.system.AllotService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Taoyongpan on 2017/9/5.
 */
public class AllotServiceTest extends AbstractTestCase {

    @Autowired
    AllotService allotService;

    /**
     * 新增测试
     * @throws SSException
     */
    @Test
    public void addTest()throws SSException{
        Allot allot = new Allot();
        allot.setUid(1);
        allot.setDid(1);
        allotService.addAllot(allot);
    }

    /**
     * 编辑测试
     * @throws SSException
     */
    @Test
    public void updateTest()throws SSException{
        Allot allot = new Allot();
        allot.setId(1);
        allot.setUid(2);
        allot.setDid(3);
        allotService.updateAllot(allot);
    }

    /**
     * 根据用户ID查找
     * @throws SSException
     */
    @Test
    public void queyByUid()throws SSException{
//        Allot allot = new Allot();
        allotService.queryByUid(2);
    }

    /**
     * 删除测试
     * @throws SSException
     */
    @Test
    public void delTest()throws SSException{
        allotService.delAllot(1);

    }

    /**
     * 罗列测试
     * @throws SSException
     */
    @Test
    public void listAllTest()throws SSException{
        allotService.listAll();
    }

    /**
     * 计算测试
     * @throws SSException
     */
    @Test
    public void countAll()throws SSException{
        allotService.countAll();
    }
}
