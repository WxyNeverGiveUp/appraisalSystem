package com.pandawork.home.check;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.home.AbstractTestCase;
import com.pandawork.home.common.entity.check.Summary;
import com.pandawork.home.service.check.SummaryService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Taoyongpan on 2017/9/3.
 */
public class SummaryTest extends AbstractTestCase {

    @Autowired
    SummaryService summaryService;

    /**
     * 新增测试
     * @throws SSException
     */
    @Test
    public void addSummaryTest()throws SSException{
        Summary summary = new Summary();
        summary.setBeCheckId(1);
        summary.setCheckId(1);
        summary.setYear(2017);
        summary.setContent("nihao");
        summaryService.addSummary(summary);
    }

    @Test
    public void updateContent()throws SSException{
        Summary summary = new Summary();
        summary.setId(1);
        summary.setContent("hahah");
        summaryService.updateSummary(summary);
    }

    @Test
    public void editScore()throws SSException{
        Summary summary = new Summary();
        summary.setId(1);
        summary.setCheckId(1);
        summary.setSummaryScore(12.0);
        summaryService.updateScore(summary);
    }

    @Test
    public void queryByUser()throws SSException{
        Summary summary = new Summary();
        summary.setYear(2017);
        summary.setBeCheckId(1);
        summaryService.queryByUser(summary);
    }

    @Test
    public void listTest()throws SSException{
        System.out.println(summaryService.listAll());

    }
}
