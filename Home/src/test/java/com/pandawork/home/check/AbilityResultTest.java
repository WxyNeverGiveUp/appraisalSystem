package com.pandawork.home.check;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.home.AbstractTestCase;
import com.pandawork.home.common.entity.check.AbilityResult;
import com.pandawork.home.service.check.AbilityResultService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Taoyongpan on 2017/9/3.
 */
public class AbilityResultTest extends AbstractTestCase {
    @Autowired
    AbilityResultService abilityResultService;

    /**
     * 新增测试
     * @throws SSException
     */
    @Test
    public void addResult()throws SSException{
        AbilityResult abilityResult = new AbilityResult();
        abilityResult.setBeCheckId(1);
        abilityResult.setCheckId(1);
        abilityResult.setRid(1);
        abilityResult.setYear(2017);
        abilityResult.setDid(1);
        abilityResult.setTotalScore(12.2);
        abilityResult.setFinishTime("21021020");
        abilityResultService.addResult(abilityResult);
    }

    /**
     * 编辑问题
     * @throws SSException
     */
    @Test
    public void updateResult()throws SSException{
        AbilityResult abilityResult = new AbilityResult();
        abilityResult.setCheckId(1);
        abilityResult.setTotalScore(21.3);
        abilityResult.setFinishTime("748174");
        abilityResultService.updateResult(abilityResult);
    }

    /**
     * 删除测试
     * @throws SSException
     */
    @Test
    public void delResult()throws SSException{
        abilityResultService.delResult(1);
    }

    @Test
    public void countAll()throws SSException{
        abilityResultService.coutAll();
    }

    /**
     * 根据部门ID查找
     * @throws SSException
     */
    @Test
    public void queryByDid()throws SSException{
        abilityResultService.queryByDid(1);
    }


    @Test
    public void listAll()throws SSException{
        abilityResultService.listAll();
    }
}
