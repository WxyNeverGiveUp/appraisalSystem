package com.pandawork.home.web.controller.system;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.core.common.log.LogClerk;
import com.pandawork.home.common.entity.system.Allot;
import com.pandawork.home.common.entity.system.Department;
import com.pandawork.home.common.entity.user.User;
import com.pandawork.home.service.system.AllotService;
import com.pandawork.home.service.system.DepartmentService;
import com.pandawork.home.service.user.UserService;
import com.pandawork.home.web.controller.AbstractController;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Taoyongpan on 2017/9/5.
 * 管辖分配的Controller
 */
@Controller
@RequestMapping("/allot")
public class AllotController extends AbstractController {

    @Autowired
    AllotService allotService;
    @Autowired
    UserService userService;
    @Autowired
    DepartmentService departmentService;

    /**
     * 获取列表
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String list(Model model)throws Exception{
        try{
            List<Allot> allotList  = allotService.listAll();
            List<User> userList = userService.listAll();
            List<Department> departmentList = departmentService.listAll();
            List<User> userList1 = userService.queryByRidAndIsDelete(7,1);
            model.addAttribute("allotList",allotList);
            model.addAttribute("userList",userList);
            model.addAttribute("departmentList",departmentList);
            model.addAttribute("userList1",userList1);
            return "system/allot-list";
        }catch (SSException e){
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }

    /**
     * 根据ID删除
     * @param id
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/ajax/del",method = RequestMethod.GET)
    public JSONObject del(@RequestParam("id") int id)throws Exception{
        try{
            allotService.delAllot(id);
            return sendJsonObject(1);
        }catch (SSException e){
            LogClerk.errLog.error(e);
            return sendErrMsgAndErrCode("操作失败！");
        }
    }

    /**
     * 新增
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String add(@RequestParam("uid") int uid, @RequestParam("did") int did)throws Exception{
        try{
            Allot allot = new Allot();
            allot.setUid(uid);
            allot.setDid(did);
            allotService.addAllot(allot);
            return "redirect:/allot/list";
        }catch (SSException e){
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }

    /**
     * 跳转到编辑管辖分配
     * @param id
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/ajax/update",method = RequestMethod.GET)
    public JSONObject update(@RequestParam("id") int id)throws Exception{
        List<Allot> allotList =  allotService.queryByUid(id);

        int i = 0;
        int did[] = new int[allotList.size()];
        for (Allot allot:allotList){
            did[i] = allot.getDid();
            i++;
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("did",did);
        return sendJsonObject(jsonObject);
//       return sendJsonObject(0);
    }

    /**
     * 编辑管辖分配范围
     * @param id
     * @param dids
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/update",method = RequestMethod.GET)
    public JSONObject update(@RequestParam("id") int id,@RequestParam("did[]") List<Integer>dids)throws Exception{
        List<Allot> list = allotService.queryByUid(id);
        for (Allot i:list){
            allotService.delAllot(i.getId());
        }
        for (int i:dids){
            Allot allot = new Allot();
            allot.setUid(id);
            allot.setDid(i);
//            System.out.println(allot+"i");
            allotService.addAllot(allot);
        }
        return sendJsonObject(1);
    }
}
