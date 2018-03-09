package com.pandawork.home.system;

import com.pandawork.home.AbstractTestCase;
import com.pandawork.home.common.entity.system.Role;
import com.pandawork.home.service.system.RoleService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Taoyongpan on 2017/8/14.
 */
public class RoleServiceTest extends AbstractTestCase {
    @Autowired
    RoleService roleService;

    /**
     * 角色新增测试
     * @throws Exception
     */
    @Test
    public void addRoleTest() throws Exception {
        Role role = new Role();
        role.setName("副总经理");
        role.setPid(1);
        roleService.addRole(role);
    }

    /**
     * 删除角色测试
     * @throws Exception
     */
    @Test
    public void delRoleTest() throws Exception {
        Role role = new Role();
        role.setId(1);
        role.setIsDelete(0);
        roleService.delRole(role);
    }

    /**
     * 编辑角色测试
     * @throws Exception
     */
    @Test
    public void updateRoleTest() throws Exception {
        Role role = new Role();
        role.setId(2);
        role.setName("管理员");
        roleService.updateRole(role);
    }

    /**
     * 罗列测试
     * @throws Exception
     */
    @Test
    public void listAllTest() throws Exception {
        System.out.println(roleService.listAll());
    }

    /**
     * 根据ID查找测试
     * @throws Exception
     */
    @Test
    public void queryByIdTest()throws Exception{
        roleService.queryById(2);
    }

    /**
     * 根据名字查找测试
     * @throws Exception
     */
    @Test
    public void queryByNameTest()throws Exception{
        roleService.queryByName("副总经理");
    }

    /**
     * 根据删除状态查找测试
     * @throws Exception
     */
    @Test
    public void queryByIsDelete()throws Exception{
        roleService.queryByIsDelete(1);
    }
}
