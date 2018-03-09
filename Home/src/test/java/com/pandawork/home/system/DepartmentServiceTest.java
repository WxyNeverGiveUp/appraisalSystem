package com.pandawork.home.system;

import com.pandawork.home.AbstractTestCase;
import com.pandawork.home.common.entity.system.Department;
import com.pandawork.home.service.system.DepartmentService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Taoyongpan on 2017/8/13.
 */
public class DepartmentServiceTest extends AbstractTestCase {
    @Autowired
    DepartmentService departmentService;

    /**
     * 新增部门
     * @throws Exception
     */
    @Test
    public void addDepartmentTest() throws Exception {
        Department department = new Department();
        department.setName("管理部门");
        departmentService.addDepartment(department);
    }

    /**
     * 根据部门删除部门
     * @throws Exception
     */
    @Test
    public void delTest() throws Exception {
        Department department = new Department();
        department.setId(1);
        department.setIsDelete(0);
        departmentService.delDepartment(department);
    }

    /**
     * 更新部门信息
     * @throws Exception
     */
    @Test
    public void updateTest() throws Exception {
        Department department = new Department();
        department.setId(2);
        department.setName("安全部门");
        departmentService.updateDepartment(department);
    }

    /**
     * 根据ID查找
     * @throws Exception
     */
    @Test
    public void queryByIdTest() throws Exception {
        departmentService.queryById(2);
    }

    /**
     * 根据名字查找
     * @throws Exception
     */
    @Test
    public void queryByNameTest()throws Exception{
        departmentService.queryByName("管理部门");
    }

    /**
     * 根据删除状态查找
     * @throws Exception
     */
    @Test
    public void queryByIsDelteTest() throws Exception {
        departmentService.queryByIsDelete(1);
    }

    /**
     * 列出所有的部门
     * @throws Exception
     */
    @Test
    public void listAllTest()throws Exception{
        departmentService.listAll();
    }

}
