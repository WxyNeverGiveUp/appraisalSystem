package com.pandawork.home.service.system.impl;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.core.common.log.LogClerk;
import com.pandawork.core.common.util.Assert;
import com.pandawork.home.common.entity.system.Role;
import com.pandawork.home.common.exception.ChException;
import com.pandawork.home.mapper.system.RoleMapper;
import com.pandawork.home.service.system.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Taoyongpan on 2017/8/14.
 */
@Service(value = "roleService")
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleMapper roleMapper;
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SSException.class,Exception.class, RuntimeException.class})
    public void addRole(Role role) throws Exception {
        try{
            if (Assert.isNull(role)){
                return;
            }
            roleMapper.addRole(role);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.AddRoleFailed);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SSException.class,Exception.class, RuntimeException.class})
    public void delRole(Role role) throws Exception {
        try{
            if (Assert.isNull(role)){
                return;
            }
            roleMapper.delRole(role);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.DelRoleFailed);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SSException.class,Exception.class, RuntimeException.class})
    public void updateRole(Role role) throws Exception {
        try{
            if (Assert.isNull(role)){
                return;
            }
            roleMapper.updateRole(role);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.UpdateRoleFailed);
        }
    }

    @Override
    public List<Role> listAll() throws Exception {
        try{
            return roleMapper.listAll();
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.ListAllRoleFailed);
        }
    }

    @Override
    public Role queryById(int id) throws Exception {
        try{
            if (Assert.isNull(id)){
                return null;
            }
            return roleMapper.queryById(id);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.QueryRoleByIdFailed);
        }
    }

    @Override
    public Role queryByName(String name) throws Exception {
        try{
            if(Assert.isNull(name)){
                return null;
            }
            return roleMapper.queryByName(name);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.QueryRoleByNameFailed);
        }
    }

    @Override
    public List<Role> queryByIsDelete(int isDelete) throws Exception {
        try{
            if (Assert.isNull(isDelete)){
                return null;
            }
            return roleMapper.queryByIsDelete(isDelete);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.QueryRoleByIsDeleteFailed);
        }
    }
}
