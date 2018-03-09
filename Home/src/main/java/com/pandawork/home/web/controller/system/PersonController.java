package com.pandawork.home.web.controller.system;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.core.common.log.LogClerk;
import com.pandawork.home.common.dto.AllotDto;
import com.pandawork.home.common.entity.system.Department;
import com.pandawork.home.common.entity.system.Role;
import com.pandawork.home.common.entity.user.User;
import com.pandawork.home.common.util.Md5Util;
import com.pandawork.home.service.check.TestPlanService;
import com.pandawork.home.service.system.DepartmentService;
import com.pandawork.home.service.system.RoleService;
import com.pandawork.home.service.user.UserService;
import com.pandawork.home.web.controller.AbstractController;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * Created by Taoyongpan on 2017/9/4.
 */

@Controller
@RequestMapping("/user")
public class PersonController extends AbstractController {
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;
    @Autowired
    DepartmentService departmentService;
    @Autowired
    TestPlanService testPlanService;

    /**
     * 获取用户列表
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String toPerson(Model model)throws Exception{
        try{
            List<AllotDto> userList = testPlanService.listAllUser();
            List<Role> roleList = roleService.listAll();
            List<Department> departmentList = departmentService.listAll();
            model.addAttribute("userList",userList);
            model.addAttribute("roleList",roleList);
            model.addAttribute("departmentList",departmentList);
            return "system/personnel-list";
        }catch (SSException e){
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }

    /**
     * 初始化用户的密码
     * @param id
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/init/password", method = RequestMethod.GET)
    public JSONObject initPassword(@RequestParam("id") int id)throws Exception{
        User user = new User();
        user.setId(id);
        user.setPassword(Md5Util.EncoderByMd5("123456"));
        userService.updatePassword(user);
        return sendJsonObject(1);
    }
    /**
     * 根据ID删除用户信息
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/ajax/del",method = RequestMethod.GET)
    public JSONObject del(@RequestParam("id") int id){
        try{
            User user = userService.queryById(id);
            user.setIsDelete(0);
            userService.delUser(user);

            return sendJsonObject(1);
        }catch (SSException e){
            LogClerk.errLog.error(e);
            return sendErrMsgAndErrCode("操作失败！");
        }
    }

    /**
     * 跳转到人员列表
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/account/list",method = RequestMethod.GET)
    public String toAccount(Model model)throws Exception{
        try{
            List<AllotDto> userList = testPlanService.listAllUser();
            List<Role> roleList = roleService.listAll();
            List<Department> departmentList = departmentService.listAll();
            model.addAttribute("userList",userList);
            model.addAttribute("roleList",roleList);
            model.addAttribute("departmentList",departmentList);
            return "system/account-list";
        }catch (SSException e){
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }

    /**
     * 审核通过
     * @param id
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/status",method = RequestMethod.GET)
    public JSONObject status(@RequestParam("id") int id)throws Exception{
        try{
            User user = userService.queryById(id);
            int i = user.getStatus();
            if (i==0||i==2){
                i =1;
            }
            user.setStatus(i);
            userService.statusUser(user);
            return sendJsonObject(1);
        }catch (SSException e){
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return sendErrMsgAndErrCode("操作失败！");
        }
    }
    /**
     * 审核不通过
     * @param id
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/status/not",method = RequestMethod.GET)
    public JSONObject statusN(@RequestParam("id") int id)throws Exception{
        try{
            User user = userService.queryById(id);
            int i = user.getStatus();
            if (i==0||i==1){
                i =2;
            }
            user.setStatus(i);
            userService.statusUser(user);
            return sendJsonObject(1);
        }catch (SSException e){
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return sendErrMsgAndErrCode("操作失败！");
        }
    }

    /**
     * 编辑用户信息
     * @param id
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/ajax/update",method = RequestMethod.GET)
    public JSONObject update(@RequestParam("id") int id)throws Exception{
        User user = userService.queryById(id);
        List<Role> roleList = roleService.listAll();
        List<Department> departmentList = departmentService.listAll();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("user",user);
        jsonObject.put("roleList",roleList);
        jsonObject.put("departmentList",departmentList);
        return  sendJsonObject(jsonObject);
    }

    @ResponseBody
    @RequestMapping(value = "/update",method = RequestMethod.GET)
    public JSONObject update(@RequestParam("id") int id, @RequestParam("username") String username, @RequestParam("realName") String realName, @RequestParam("did") int did, @RequestParam("rid") int rid, @RequestParam("phone") String phone)throws Exception{

        User user = userService.queryById(id);
        user.setUsername(username);
        user.setRealName(realName);
        user.setRid(rid);
        user.setDid(did);
        user.setPhone(phone);
        userService.updateUser(user);
        if (user==null){
            return sendJsonObject(0);
        }else {
            return sendJsonObject(1);
        }
    }

    /**
     * 用户添加
     * @param username
     * @param realName
     * @param did
     * @param rid
     * @param password
     * @param phone
     * @return
     * @throws SSException
     * @throws UnsupportedEncodingException
     * @throws NoSuchAlgorithmException
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String addUser(@RequestParam("username") String username,@RequestParam("realName") String realName,@RequestParam("did") int did,@RequestParam("rid") int rid,@RequestParam("password") String password,@RequestParam("phone") String phone) throws SSException, UnsupportedEncodingException, NoSuchAlgorithmException {
        User user = new User();
        user.setUsername(username);
        user.setRealName(realName);
        user.setDid(did);
        user.setPassword(Md5Util.EncoderByMd5(password));
        user.setPhone(phone);
        user.setRid(rid);//默认注册人员为一般员工
        user.setStatus(1);//默认为未审核状态
        userService.addUser(user);
        return "redirect:/user/list";
    }
}
