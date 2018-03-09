package com.pandawork.home.web.controller.check;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.home.common.entity.check.TestPlan;
import com.pandawork.home.common.entity.user.User;
import com.pandawork.home.service.check.*;
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
@RequestMapping("/ability")
public class AbilityController extends AbstractController {
    @Autowired
    AbilityOptionService abilityOptionService;
    @Autowired
    AbilityPositionService abilityPositionService;
    @Autowired
    AbilityResultService abilityResultService;
    @Autowired
    AbilityTargetService abilityTargetService;
    @Autowired
    AbilityTargetTypeService abilityTargetTypeService;
    @Autowired
    TestPlanService testPlanService;
    @Autowired
    UserService userService;


    /**
     * 获取列表页面
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String list(Model model, HttpSession session)throws Exception{
        User user = userService.queryByUname((String) session.getAttribute("username"));
        int testTypeId = 3;
        List<TestPlan> testPlanList = testPlanService.queryByTypeId(testTypeId);
        model.addAttribute("testPlanList",testPlanList);
        return "evaluation/year/ability-list";
    }

    /**
     * 跳转到详情页
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/detail/{id}",method = RequestMethod.GET)
    public String detail(@PathVariable("id") int id,Model model)throws Exception{


        return "evaluation/year/ability-detail";
    }

    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    public String user(int id)throws SSException{
        return "evaluation/year/ability-user";
    }
}
