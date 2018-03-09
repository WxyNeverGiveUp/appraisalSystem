package com.pandawork.home.web.controller.system;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.core.common.log.LogClerk;
import com.pandawork.home.common.entity.check.Summary;
import com.pandawork.home.common.entity.system.Department;
import com.pandawork.home.common.entity.system.Role;
import com.pandawork.home.common.entity.user.User;
import com.pandawork.home.service.check.SummaryService;
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
 * Created by Taoyongpan on 2017/9/8.
 */
@Controller
@RequestMapping("/summary")
public class SummaryController extends AbstractController {
    @Autowired
    SummaryService summaryService;
    @Autowired
    DepartmentService departmentService;
    @Autowired
    RoleService roleService;
    @Autowired
    UserService userService;

    /**
     * 列出所有的年度总结
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String list(Model model, HttpSession session)throws Exception{
        try{
            String username = (String) session.getAttribute("username");
            User user = userService.queryByUname(username);
            Summary summary = new Summary();
            summary.setBeCheckId(user.getId());
            List<Summary> summaryList = summaryService.queryByUser(summary);
            List<Department> departmentList = departmentService.listAll();
            List<Role> roleList = roleService.listAll();
            model.addAttribute("summaryList",summaryList);
            model.addAttribute("departmentList",departmentList);
            model.addAttribute("roleList", roleList);
            model.addAttribute("user",user);
            return "evaluation/year/summary-list";
        }catch (SSException e){
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }

    /**
     * 跳转到详情页面
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/detail/{id}",method = RequestMethod.GET)
    public String detail(@PathVariable("id") int id,Model model,HttpSession session)throws Exception{
        try {
            String username = (String) session.getAttribute("username");
            Summary summary = summaryService.queryById(id);
            model.addAttribute("summary",summary);
            model.addAttribute("username",username);
            return "evaluation/year/summary-detail";
        }catch (SSException e){
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }

    /**
     * 跳转到新增页面
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/toadd",method = RequestMethod.GET)
    public String toAdd()throws Exception{
        return "evaluation/year/summary-add";
    }

    /**
     * 新增年度总结
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String add(@RequestParam("year") int year,@RequestParam("content") String content,HttpSession session)throws Exception{
        try {
            String username = (String) session.getAttribute("username");
            User user = userService.queryByUname(username);
            Summary summary = new Summary();
            summary.setBeCheckId(user.getId());
            summary.setYear(year);
            summary.setContent(content);
            summary.setDid(user.getDid());
            summaryService.addSummary(summary);
            return "redirect:/summary/list";
        }catch (SSException e){
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }

    /**
     * 跳转到新增页面
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/toupdate/{id}",method = RequestMethod.GET)
    public String toUpdate(@PathVariable("id") int id,Model model)throws Exception{
        Summary summary = summaryService.queryById(id);
        model.addAttribute("summary",summary);
        return "evaluation/year/summary-update";
    }

    /**
     * 编辑年度总结
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/update/{id}",method = RequestMethod.POST)
    public String update(@PathVariable("id") int id,@RequestParam("content") String content)throws Exception{
        try {
            Summary summary = summaryService.queryById(id);
            summary.setContent(content);
            summaryService.updateSummary(summary);
            return "redirect:/summary/detail/"+id;
        }catch (SSException e){
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }

    /**
     * 判断是否可以添加成功
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/judge/add",method = RequestMethod.POST)
    public JSONObject judgeAdd(@RequestParam("year") int year,HttpSession session) throws SSException {
        String username = (String) session.getAttribute("username");
        User user = userService.queryByUname(username);
        Summary summary = summaryService.queryByUidAndYear(user.getId(), year);
        if (summary==null){
            return  sendJsonObject(1);
        }else {
            return sendJsonObject(0);
        }
    }
}
