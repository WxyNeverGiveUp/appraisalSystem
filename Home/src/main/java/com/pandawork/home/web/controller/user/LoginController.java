package com.pandawork.home.web.controller.user;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.core.common.util.Assert;
import com.pandawork.home.common.entity.system.Department;
import com.pandawork.home.common.entity.system.Power;
import com.pandawork.home.common.entity.system.Role;
import com.pandawork.home.common.entity.user.User;
import com.pandawork.home.service.system.DepartmentService;
import com.pandawork.home.service.system.PowerService;
import com.pandawork.home.service.system.RoleService;
import com.pandawork.home.service.user.UserService;
import com.pandawork.home.web.controller.AbstractController;
import com.pandawork.home.common.util.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * Created by Taoyongpan on 2017/9/2.
 */
@Controller
@RequestMapping("")
public class LoginController extends AbstractController {

    @Autowired
    UserService userService;
    @Autowired
    DepartmentService departmentService;
    @Autowired
    RoleService roleService;
    @Autowired
    PowerService powerService;

    /**
     * 跳到登录页面
     * @param req
     * @param model
     * @return
     */
    @RequestMapping(value = "/tologin")
    public String toLogin(HttpServletRequest req, Model model){
        return "login";
    }

    /**
     * 登录验证
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(HttpServletRequest request, HttpServletResponse response, @RequestParam("username") String username, @RequestParam("password") String password, HttpSession session,Model model) throws Exception {
        User user = userService.queryByUname(username);
        session.setAttribute("username1",username);
        if (!Assert.isNull(user)){
            if (user.getPassword().equals(Md5Util.EncoderByMd5(password))&&user.getIsDelete()==1){
                if (user.getStatus()==1){
                    Department department = departmentService.queryById(user.getDid());
                    Role role = roleService.queryById(user.getRid());
                    Power power = powerService.queryById(role.getPid());
                    session.setMaxInactiveInterval(30*60);//设置session的有效时间
                    session.setAttribute("department",department.getName());
                    session.setAttribute("role",role.getName());
                    session.setAttribute("power",power.getPower());
                    session.setAttribute("username",user.getUsername());
                    session.setAttribute("uid",user.getId());
                    session.setAttribute("did",user.getDid());
                    //月份成绩查询
                    session.setAttribute("queryMonthDid",-1);
                    session.setAttribute("queryMonthRid",-1);
                    session.setAttribute("queryMonthYear",-1);
                    session.setAttribute("queryMonthUName","");
                    //季度成绩查询
                    session.setAttribute("queryQuarterDid",-1);
                    session.setAttribute("queryQuarterRid",-1);
                    session.setAttribute("queryQuarterYear",-1);
                    session.setAttribute("queryQuarterUName","");
//                    session.setAttribute("id");
                    return "index";
                }else {
                    model.addAttribute("error","审核未通过或者管理员还没有进行审核");
                    return "login";
                }
            }else {
                model.addAttribute("error","用户名或密码错误");
                return "login";
            }
        }else {
            model.addAttribute("error","用户名或密码错误");
            return "login";
        }
    }

    /**
     * 跳转到主页
     * @return
     */
    @RequestMapping(value = "/toindex",method = RequestMethod.GET)
    public String toIndex(){
        return "index";
    }
    /**
     * 跳转到注册页面
     * @return
     */
    @RequestMapping(value = "/toregister",method = RequestMethod.GET)
    public String toRegister(Model model) throws Exception {

        List<Department> departmentList = departmentService.listAll();
        model.addAttribute("departmentList",departmentList);
        return "register";
    }
    /**
     * 注册新用户
     * @return
     */
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String register(@RequestParam("username") String username,@RequestParam("realName") String realName,@RequestParam("did") int did,@RequestParam("password") String password,@RequestParam("phone") String phone,Model model) throws SSException, UnsupportedEncodingException, NoSuchAlgorithmException {
        if (userService.queryByUname(username)!=null){
            model.addAttribute("error","账户名已经存在！");
            return "register";
        }else {
            User user = new User();
            user.setUsername(username);
            user.setRealName(realName);
            user.setDid(did);
            user.setPassword(Md5Util.EncoderByMd5(password));
            user.setPhone(phone);
            user.setRid(10);//默认注册人员为一般员工
            user.setStatus(0);//默认为未审核状态
            userService.addUser(user);
            return "login";
        }
    }

    /**
     * 跳转到更新页面
     * @return
     * @throws SSException
     */
    @RequestMapping(value = "/toupwd",method = RequestMethod.GET)
    public String toUpdatePassword(HttpSession session,Model model)throws SSException{
        User user = userService.queryByUname((String) session.getAttribute("username"));
        model.addAttribute("user",user);
        return "update-password";
    }

    /**
     * 更新密码
     * @return
     * @throws SSException
     */
    @RequestMapping(value = "/upwd",method = RequestMethod.POST)
    public String updatePassword(Model model,HttpSession session,@RequestParam("password") String password,@RequestParam("newPassword") String newPassword) throws SSException, UnsupportedEncodingException, NoSuchAlgorithmException {
        User user = userService.queryByUname((String) session.getAttribute("username"));
        if (user.getPassword().equals(Md5Util.EncoderByMd5(password))){
            user.setPassword(Md5Util.EncoderByMd5(newPassword));
            userService.updatePassword(user);
            session.invalidate();
            return "login";
        }else {
            model.addAttribute("msg","原密码错误");
            return "update-password";
        }
    }

    /**
     * 注销登录
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String logout(HttpSession session)throws Exception{
        session.removeAttribute("username");
        session.removeAttribute("power");
        session.removeAttribute("role");
        session.removeAttribute("department");
        return "login";
    }

}
