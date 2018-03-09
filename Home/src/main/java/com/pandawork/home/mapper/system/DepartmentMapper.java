package com.pandawork.home.mapper.system;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.home.common.entity.system.Department;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Taoyongpan on 2017/8/13.
 */
public interface DepartmentMapper {
    /**
     * 新增部门，默认为非删除状态
     * @param department
     * @throws SSException
     */
    public void addDepartment(@Param("department") Department department)throws SSException;

    /**
     * 删除部门（假删）
     * @param department
     * @throws SSException
     */
    public void delDepartment(@Param("department") Department department)throws SSException;

    /**
     * 编辑部门名字
     * @param department
     * @throws SSException
     */
    public void updateDepartment(@Param("department") Department department)throws SSException;

    /**
     * 根据部门ID查找
     * @param id
     * @return
     * @throws SSException
     */
    public Department queryById(@Param("id") int id)throws SSException;

    /**
     * 根据名字查找
     * @param name
     * @return
     * @throws SSException
     */
    public Department queryByName(@Param("name") String name)throws SSException;

    /**
     * 根据是否删除查找
     * @param isDelete
     * @return
     * @throws SSException
     */
    public List<Department> queryByIsDelete(@Param("isDelete") int isDelete)throws SSException;

    /**
     * 列出所有的部门
     * @return
     * @throws SSException
     */
    public List<Department> listAll()throws SSException;

    /**
     * 查出所有的ID
     * @return
     * @throws SSException
     */
    public List<Integer> queryId()throws SSException;


}
