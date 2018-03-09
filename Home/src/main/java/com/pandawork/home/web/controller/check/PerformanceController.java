package com.pandawork.home.web.controller.check;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.core.common.log.LogClerk;
import com.pandawork.home.common.entity.check.JoinTest;
import com.pandawork.home.common.entity.check.Performance;
import com.pandawork.home.common.entity.check.TestPlan;
import com.pandawork.home.common.entity.check.WorkPlan;
import com.pandawork.home.common.entity.user.User;
import com.pandawork.home.service.check.JoinTestService;
import com.pandawork.home.service.check.PerformanceService;
import com.pandawork.home.service.check.TestPlanService;
import com.pandawork.home.service.check.WorkPlanService;
import com.pandawork.home.service.user.UserService;
import com.pandawork.home.web.controller.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Taoyongpan on 2017/9/8.
 */
@Controller
@RequestMapping("/performance")
public class PerformanceController extends AbstractController {
    @Autowired
    PerformanceService performanceService;
    @Autowired
    UserService userService;
    @Autowired
    WorkPlanService workPlanService;
    @Autowired
    TestPlanService testPlanService;
    @Autowired
    JoinTestService joinTestService;
    /**
     * 获取每一年的详情
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/detail/{id}",method = RequestMethod.GET)
    public String detail(@PathVariable("id") int id, Model model, HttpSession session)throws Exception{
        try{
            User user = userService.queryByUname((String) session.getAttribute("username"));
            TestPlan testPlan = testPlanService.queryTestPlan(id);
            List<WorkPlan> workPlanList = workPlanService.queryByUidAndYear(user.getId(),testPlan.getYear());
            Performance performance = performanceService.queryByUidAndYear(user.getId(),testPlan.getYear());
            int sumScore = 0;
            if (testPlan.getTestTypeId()==1){
                for (WorkPlan workPlan :workPlanList){
                    sumScore+=workPlan.getQueaterScore();
                }
                sumScore/=4;
                model.addAttribute("sumScore",sumScore);
            }else if (testPlan.getTestTypeId()==2){
                for (WorkPlan workPlan :workPlanList){
                    sumScore+=workPlan.getMonthScore();
                }
                sumScore/=12;
                model.addAttribute("sumScore",sumScore);
            }
            model.addAttribute("workPlanList",workPlanList);
            model.addAttribute("performance",performance);
            model.addAttribute("testPlan",testPlan);
            return "evaluation/year/synthetical-detail";
        }catch (SSException e){
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }

    /**
     * 获取综合绩效列表页
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String list(Model model, HttpSession session)throws Exception{
        User user = userService.queryByUname((String) session.getAttribute("username"));
        List<JoinTest> joinTestList = joinTestService.queryByUid(user.getId());
        List<TestPlan> testPlanList = testPlanService.listAll();
        model.addAttribute("joinTestList",joinTestList);
        model.addAttribute("testPlanList",testPlanList);
        return "evaluation/year/synthetical-list";
    }

}
