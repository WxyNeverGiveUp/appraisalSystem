package com.pandawork.home.service.system;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.home.common.entity.system.Department;

import java.util.List;

/**
 * Created by Taoyongpan on 2017/8/13.
 */
public interface DepartmentService {
    /**
     * 新增部门
     * @param department
     * @throws Exception
     */
    public void addDepartment(Department department)throws Exception;

    /**
     * 根据ID删除部门
     * @param department
     * @throws Exception
     */
    public void delDepartment(Department department)throws Exception;

    /**
     * 更新部门信息
     * @param department
     * @throws Exception
     */
    public void updateDepartment(Department department)throws Exception;

    /**
     * 根据ID查找部门
     * @param id
     * @return
     * @throws Exception
     */
    public Department queryById(int id)throws Exception;

    /**
     * 根据名字查找部门信息
     * @param name
     * @return
     * @throws Exception
     */
    public Department queryByName(String name)throws Exception;

    /**
     * 根据是否删除查找部门
     * @param isDelete
     * @return
     * @throws Exception
     */
    public List<Department> queryByIsDelete(int isDelete)throws Exception;

    /**
     * 列出所有的部门
     * @return
     * @throws Exception
     */
    public List<Department> listAll()throws Exception;

    /**
     * 查出所有的ID
     * @return
     * @throws SSException
     */
    public List<Integer> queryId()throws SSException;
}
