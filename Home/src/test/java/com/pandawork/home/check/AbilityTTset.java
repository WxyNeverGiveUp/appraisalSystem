package com.pandawork.home.check;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.home.AbstractTestCase;
import com.pandawork.home.common.entity.check.AbilityTarget;
import com.pandawork.home.service.check.AbilityTargetService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Taoyongpan on 2017/8/31.
 */
public class AbilityTTset extends AbstractTestCase {
    @Autowired
    AbilityTargetService abilityTargetService;

    @Test
    public void addTest()throws SSException{
        AbilityTarget abilityTarget = new AbilityTarget();
        abilityTarget.setTypeId(2);
        abilityTarget.setName("taoq");
        abilityTargetService.addTarget(abilityTarget);
    }

    @Test
    public void delTest()throws SSException{
        abilityTargetService.delTarget(1);
    }

    @Test
    public void updateTest()throws SSException{
        AbilityTarget abilityTarget = new AbilityTarget();
        abilityTarget.setId(2);
        abilityTarget.setTypeId(1);
        abilityTarget.setName("taotao");
        abilityTargetService.updateTarget(abilityTarget);
    }

    @Test
    public void listAllTest()throws SSException{
        abilityTargetService.listAll();
    }
}
