package com.pandawork.home.check;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.home.AbstractTestCase;
import com.pandawork.home.common.entity.check.TestType;
import com.pandawork.home.service.check.TestTypeService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Taoyongpan on 2017/8/29.
 */
public class TestTypeTest extends AbstractTestCase {
    @Autowired
    TestTypeService testTypeService;

    /**
     * 新增测试
     * @throws SSException
     */
    @Test
    public void testAddTestType()throws SSException{
        TestType testType = new TestType();
        testType.setName("年度考核");
        testTypeService.addTestType(testType);
    }

    /**
     * 删除 测试
     * @throws SSException
     */
    @Test
    public void testDel()throws SSException{
        testTypeService.delTestType(1);
    }

    /**
     * 更新测试
     * @throws SSException
     */
    @Test
    public void testIpdate()throws SSException{
        TestType testType = new TestType();
        testType.setId(2);
        testType.setName("年度考核");
        testTypeService.updateTestType(testType);
    }

    /**
     * 列表测试
     * @throws SSException
     */
    @Test
    public void testLisetAll()throws SSException{
        testTypeService.listAll();
    }

}
