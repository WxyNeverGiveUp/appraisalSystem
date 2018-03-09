package com.pandawork.home.web.controller.check;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.core.common.log.LogClerk;
import com.pandawork.home.common.dto.AllotDto;
import com.pandawork.home.common.entity.check.*;
import com.pandawork.home.common.entity.user.User;
import com.pandawork.home.service.check.*;
import com.pandawork.home.service.system.DepartmentService;
import com.pandawork.home.service.system.RoleService;
import com.pandawork.home.service.user.UserService;
import com.pandawork.home.web.controller.AbstractController;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Taoyongpan on 2017/9/6.
 */
@Controller
@RequestMapping("/testplan")
public class TestPlanController extends AbstractController{
    @Autowired
    WorkPlanService workPlanService;
    @Autowired
    TestPlanService testPlanService;
    @Autowired
    TestTypeService testTypeService;
    @Autowired
    UserService userService;
    @Autowired
    DepartmentService departmentService;
    @Autowired
    RoleService roleService;
    @Autowired
    JoinTestService joinTestService;
    @Autowired
    AbilityTestService abilityTestService;

    /**
     * 获取考核计划列表
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String list(Model model)throws Exception{
        try {
            List<TestPlan> testPlanList = testPlanService.listAll();
            List<TestType> testTypeList = testTypeService.listAll();
            model.addAttribute("testPlanList",testPlanList);
            model.addAttribute("testTypeList",testTypeList);
            return "evaluation/plan-management";
        }catch (SSException e){
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }

    }

    /**
     * 跳转到修改考核计划页面
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/to/update",method = RequestMethod.GET)
    public JSONObject toUpdate(@RequestParam("id") int id, Model model)throws Exception{
        TestPlan testPlan = testPlanService.queryTestPlan(id);
        List<TestType> testTypeList = testTypeService.listAll();
        model.addAttribute("testPlan",testPlan);
        model.addAttribute("testTypeList",testTypeList);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("testPlan",testPlan);
        jsonObject.put("testTypeList",testTypeList);
        return sendJsonObject(jsonObject);
    }

    /**
     * 更新考核计划内容
     * @param testId
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/update",method = RequestMethod.GET)
    public JSONObject update(@RequestParam("testId") int testId,@RequestParam("testName") String testName,@RequestParam("testTypeId") int testTypeId,@RequestParam("startTime") String startTime,@RequestParam("year") int year)throws Exception{
        TestPlan testPlan = new TestPlan();
        testPlan.setId(testId);
        testPlan.setYear(year);
        testPlan.setTestName(testName);
        testPlan.setTestTypeId(testTypeId);
        testPlan.setStartTime(startTime);
        testPlanService.updateTestPlan(testPlan);
        return sendJsonObject(1);
    }
    /**
     * 改变考核计划的开启状态
     * @param id
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/edit",method = RequestMethod.GET)
    public JSONObject edit(@RequestParam("id") int id)throws Exception{
        try {
            TestPlan testPlan = testPlanService.queryTestPlan(id);
            if (testPlan.getIsAvailable()==1){
                testPlan.setIsAvailable(2);
            }else if (testPlan.getIsAvailable()==0){
                testPlan.setIsAvailable(1);
            }else if (testPlan.getIsAvailable()==2){
                testPlan.setIsAvailable(0);
            }
            testPlanService.delTestPlan(testPlan);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("code",1);
            jsonObject.put("status",testPlan.getIsAvailable());
            return sendJsonObject(jsonObject);
        }catch (SSException e){
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return sendErrMsgAndErrCode("错误");
        }
    }

    /**
     * 根据ID删除
     * @param id
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/del",method = RequestMethod.GET)
    public JSONObject del(@RequestParam("id") int id)throws Exception{
        testPlanService.del(id);
        return sendJsonObject(1);
    }
    /**
     * 跳转到新增页面
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/toadd",method = RequestMethod.GET)
    public String toAdd(Model model)throws Exception{
        try{
            List<TestType> testTypeList = testTypeService.listAll();
            model.addAttribute("testTypeList",testTypeList);
            return "evaluation/plan-management-add";
        }catch (SSException e){
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }

    /**
     *新增考核计划
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String add(@RequestParam("testName") String testName, @RequestParam("testTypeId") int testTypeId, @RequestParam("startTime") String startTime, @RequestParam("startTime") String finishTime,@RequestParam("year") int year,@RequestParam("month") int month,@RequestParam("quarter") int queater, HttpSession session)throws Exception{
        try{
            User  user = userService.queryByUname((String) session.getAttribute("username"));
            TestPlan testPlan = new TestPlan();
            testPlan.setUid(user.getId());
            testPlan.setTestName(testName);
            testPlan.setTestTypeId(testTypeId);
            testPlan.setStartTime(startTime);
            testPlan.setFinishTime(finishTime);
            testPlan.setDid(user.getDid());
            testPlan.setYear(year);
            testPlan.setMonth(month);
            testPlan.setQueater(queater);
            testPlanService.addTestPlan(testPlan);
            return "redirect:/testplan/list";
        }catch (SSException e){
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }

    /**
     * 跳转到考核分配页面
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/toallot/{id}",method = RequestMethod.GET)
    public String toAllot(@PathVariable("id") int id,Model model)throws Exception{
        TestPlan testPlan = testPlanService.queryTestPlan(id);
        List<AllotDto> list = testPlanService.listAllUser();
        List<JoinTest> joinTestList = joinTestService.queryByTid(testPlan.getId());
        if (joinTestList == null){
            model.addAttribute("joinTestList",null);
        }else {
            model.addAttribute("joinTestList",joinTestList);
        }
        model.addAttribute("list",list);
        model.addAttribute("testPlan",testPlan);
        return "evaluation/allot-detail";
    }

    /**
     * 参与考核
     * @param tid
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/join",method = RequestMethod.GET)
    public JSONObject join(@RequestParam("tid") int tid,@RequestParam("uid") int uid, HttpSession session)throws Exception{
        JoinTest joinTest = new JoinTest();
        joinTest.setUid(uid);
        joinTest.setTestId(tid);
        joinTestService.addCheck(joinTest);
        TestPlan testPlan = testPlanService.queryTestPlan(tid);
        if (testPlan.getTestTypeId()>=5){
            WorkPlan workPlan = new WorkPlan();
            workPlan.setBeCheckId(uid);
            workPlan.setTestId(tid);
            workPlan.setYear(testPlan.getYear());
            workPlan.setMonth(testPlan.getMonth());
            workPlan.setQueater(testPlan.getQueater());
            workPlanService.addWorkPlan(workPlan);
        }
        if (testPlan.getTestTypeId()==3){
            AbilityTest abilityTest = new AbilityTest();
            abilityTest.setTestId(tid);
            abilityTest.setBeCheckId(uid);
            abilityTestService.addAbilityTest(abilityTest);
        }

        return sendJsonObject(1);
    }

    /**
     * 不参与考核
     * @param tid
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/del/join",method = RequestMethod.GET)
    public JSONObject notJoin(@RequestParam("tid") int tid,@RequestParam("uid") int uid)throws Exception{
        joinTestService.delById(tid,uid);
        TestPlan testPlan = testPlanService.queryTestPlan(tid);
        if (testPlan.getTestTypeId()>=5){
            workPlanService.delWorkPlan(uid,tid);
        }
        if (testPlan.getTestTypeId()==3){
            abilityTestService.delByTidAndUid(tid, uid);
        }
        return sendJsonObject(1);
    }

    /**
     * 添加全部人员
     * @param uid
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/add/all",method = RequestMethod.GET)
    public JSONObject addAll(@RequestParam("tid") int tid,@RequestParam("uid[]") List<Integer> uid)throws Exception{
        for (int i:uid){
            JoinTest joinTest = new JoinTest();
            joinTest.setTestId(tid);
            joinTest.setUid(i);
            joinTestService.addCheck(joinTest);
            TestPlan testPlan = testPlanService.queryTestPlan(tid);
            if (testPlan.getTestTypeId()>=5){
                WorkPlan workPlan = new WorkPlan();
                workPlan.setBeCheckId(i);
                workPlan.setTestId(tid);
                workPlan.setYear(testPlan.getYear());
                workPlan.setMonth(testPlan.getMonth());
                workPlan.setQueater(testPlan.getQueater());
                workPlanService.addWorkPlan(workPlan);
            }
            if (testPlan.getTestTypeId()==3){
                AbilityTest abilityTest = new AbilityTest();
                abilityTest.setTestId(tid);
                abilityTest.setBeCheckId(i);
                abilityTestService.addAbilityTest(abilityTest);
            }
        }
        return sendJsonObject(1);
    }
}
