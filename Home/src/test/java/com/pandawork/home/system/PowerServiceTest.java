package com.pandawork.home.system;

import com.pandawork.home.AbstractTestCase;
import com.pandawork.home.common.entity.system.Power;
import com.pandawork.home.service.system.PowerService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Taoyongpan on 2017/8/13.
 */
public class PowerServiceTest extends AbstractTestCase {
    @Autowired
    PowerService powerService;

    /**
     * 新增权限测试
     * @throws Exception
     */
    @Test
    public void addPowerTest() throws Exception {
        Power power = new Power();
        power.setPower(5);
        powerService.addPower(power);
    }

    /**
     * 删除权限测试
     * @throws Exception
     */
    @Test
    public void delPowerTest() throws Exception {
        powerService.delPower(5);
    }

    /**
     * 权限更新方法测试
     * @throws Exception
     */
    @Test
    public void updatePowerTest() throws Exception {
        Power power = new Power();
        power.setId(1);
        power.setPower(2);
        powerService.updatePower(power);
    }

    /**
     * 根据ID查找权限等级
     * @throws Exception
     */
    @Test
    public void queryByIdTest() throws Exception {
        powerService.queryById(1);
    }

    /**
     * 根据power查找权限等级
     * @throws Exception
     */
    @Test
    public void queryByPowerTest() throws Exception {
        powerService.queryByPower(1);
    }

    /**
     * 列出所有用户
     * @throws Exception
     */
    @Test
    public void listAllTest()throws Exception{
        powerService.listAll();
    }
}
