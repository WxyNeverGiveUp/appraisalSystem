package com.pandawork.home.service.system;

import com.pandawork.home.common.entity.system.Role;

import java.util.List;

/**
 * Created by Taoyongpan on 2017/8/14.
 */
public interface RoleService {
    /**
     * 新增用户角色
     * @param role
     * @throws Exception
     */
    public void  addRole(Role role)throws Exception;

    /**
     * 删除用户角色
     * @param role
     * @throws Exception
     */
    public void delRole(Role role)throws Exception;

    /**
     * 编辑用户角色
     * @param role
     * @throws Exception
     */
    public void updateRole(Role role) throws Exception;

    /**
     * 列出所有角色
     * @return
     * @throws Exception
     */
    public List<Role> listAll()throws Exception;

    /**
     * 根据ID查找角色
     * @param id
     * @return
     * @throws Exception
     */
    public Role queryById(int id)throws Exception;

    /**
     * 根据名字查找角色
     * @param name
     * @return
     * @throws Exception
     */
    public Role queryByName(String name)throws Exception;

    /**
     * 根据删除状态查询
     * @param isDelete
     * @return
     * @throws Exception
     */
    public List<Role> queryByIsDelete(int isDelete)throws Exception;

}
