package com.pandawork.home.mapper.system;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.home.common.entity.system.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Taoyongpan on 2017/8/14.
 */
public interface RoleMapper {
    /**
     * 新增用户角色
     * @param role
     * @throws SSException
     */
    public void addRole(@Param("role") Role role)throws SSException;

    /**
     * 删除用户角色
     * @param role
     * @throws SSException
     */
    public void delRole(@Param("role") Role role)throws SSException;

    /**
     * 更新用户角色
     * @param role
     * @throws SSException
     */
    public void updateRole(@Param("role") Role role)throws SSException;

    /**
     * 列出所有的用户
     * @return
     * @throws SSException
     */
    public List<Role> listAll()throws SSException;

    /**
     * 根据ID查找角色
     * @param id
     * @return
     * @throws SSException
     */
    public Role queryById(@Param("id") int id)throws SSException;

    /**
     * 根据角色名字查找
     * @param name
     * @return
     * @throws SSException
     */
    public Role queryByName(@Param("name") String name)throws SSException;

    /**
     * 根据删除状态查询
     * @param isDelete
     * @return
     * @throws SSException
     */
    public List<Role> queryByIsDelete(@Param("isDelete") int isDelete)throws SSException;
}
