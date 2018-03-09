package com.pandawork.home.check;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.home.AbstractTestCase;
import com.pandawork.home.common.entity.check.AbilityOption;
import com.pandawork.home.service.check.AbilityOptionService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Taoyongpan on 2017/9/3.
 */
public class AbilityOptionTest extends AbstractTestCase {
    @Autowired
    AbilityOptionService abilityOptionService;

    /**
     * 新增测试
     * @throws SSException
     */
    @Test
    public void addOption()throws SSException{
       AbilityOption abilityOption = new
               AbilityOption();
       abilityOption.setPositionId(1);
       abilityOption.setTargetId(1);
       abilityOption.setOptionName(1);
       abilityOption.setMaxScore(10.0);
       abilityOption.setMinScore(1.2);
       abilityOption.setOptionContent("nihao");
       abilityOptionService.addOption(abilityOption);
    }

    /**
     * 删除测试
     * @throws SSException
     */
    @Test
    public void del()throws SSException{
        abilityOptionService.delOption(1);
    }

    /**
     * 编辑测试
     * @throws SSException
     */
    @Test
    public void updateOption()throws SSException{
        AbilityOption abilityOption = new AbilityOption();
        abilityOption.setId(2);
        abilityOption.setPositionId(1);
        abilityOption.setTargetId(1);
        abilityOption.setOptionName(1);
        abilityOption.setMaxScore(10.0);
        abilityOption.setMinScore(1.2);
        abilityOption.setOptionContent("nihao");
        abilityOptionService.updateOption(abilityOption);
    }

    /**
     * 根据问题ID查找
     * @throws SSException
     */
    @Test
    public void queryByPositionId()throws SSException{
        AbilityOption abilityOption = new AbilityOption();
        abilityOptionService.queryByPositionId(1);
    }
}
