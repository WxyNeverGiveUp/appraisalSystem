package com.pandawork.home.check;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.home.AbstractTestCase;
import com.pandawork.home.common.entity.check.AbilityPosition;
import com.pandawork.home.service.check.AbilityPositionService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Taoyongpan on 2017/9/1.
 */
public class AbilityPositionTest extends AbstractTestCase {

    @Autowired
    AbilityPositionService abilityPositionService;

    @Test
    public void addTest()throws SSException{
        AbilityPosition abilityPosition = new AbilityPosition();
        abilityPositionService.queryByTestId(6);
    }
}
