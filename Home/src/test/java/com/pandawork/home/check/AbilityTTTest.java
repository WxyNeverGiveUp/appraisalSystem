package com.pandawork.home.check;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.home.AbstractTestCase;
import com.pandawork.home.common.entity.check.AbilityTargetType;
import com.pandawork.home.service.check.AbilityTargetTypeService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Taoyongpan on 2017/8/31.
 */
public class AbilityTTTest extends AbstractTestCase {
    @Autowired
    AbilityTargetTypeService abilityTargetTypeService;

    /**
     * 新增测试
     * @throws SSException
     */
    @Test
    public void addTargetType()throws SSException{
        AbilityTargetType abilityTargetType = new AbilityTargetType();
        abilityTargetType.setName("lggll");
        abilityTargetTypeService.addTargetType(abilityTargetType);
    }

    /**
     * 删除测试
     * @throws SSException
     */
    @Test
    public void delTest()throws SSException{
        abilityTargetTypeService.delTargetType(1);
    }

    /**
     * 更新测试
     * @throws SSException
     */
    @Test
    public void updateTest()throws SSException{
        AbilityTargetType abilityTargetType = new AbilityTargetType();
        abilityTargetType.setId(2);
        abilityTargetType.setName("ggg");
        abilityTargetTypeService.updateTargetType(abilityTargetType);
    }


    @Test
    public void listAllTest()throws SSException{
        abilityTargetTypeService.listAll();
    }
}
