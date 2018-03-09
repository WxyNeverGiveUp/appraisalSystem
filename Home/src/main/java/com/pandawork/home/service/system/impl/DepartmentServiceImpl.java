package com.pandawork.home.service.system.impl;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.core.common.log.LogClerk;
import com.pandawork.core.common.util.Assert;
import com.pandawork.home.common.entity.system.Department;
import com.pandawork.home.common.exception.ChException;
import com.pandawork.home.mapper.system.DepartmentMapper;
import com.pandawork.home.service.system.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Taoyongpan on 2017/8/13.
 */
@Service(value = "departmentService")
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    DepartmentMapper departmentMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SSException.class,Exception.class, RuntimeException.class})
    public void addDepartment(Department department) throws Exception {
        try{
            if (Assert.isNull(department)){
                return;
            }
            departmentMapper.addDepartment(department);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.AddDepartmentFailed);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SSException.class,Exception.class, RuntimeException.class})
    public void delDepartment(Department department) throws Exception {
        try{
            if (Assert.isNull(department)){
                return;
            }
            departmentMapper.delDepartment(department);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.DelDepartmentFailed);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SSException.class,Exception.class, RuntimeException.class})
    public void updateDepartment(Department department) throws Exception {
        try{
            if (Assert.isNull(department)){
                return;
            }
            departmentMapper.updateDepartment(department);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.UpdateDepartmentFailed);
        }
    }

    @Override
    public Department queryById(int id) throws Exception {
        try{
            if (Assert.isNull(id)){
                return null;
            }
            return departmentMapper.queryById(id);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.QueryDepartmentByIdFailed);
        }
    }

    @Override
    public Department queryByName(String name) throws Exception {
        try{
            if (Assert.isNull(name)){
                return null;
            }
            return departmentMapper.queryByName(name);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.QueryDepartmentByNameFailed);
        }
    }

    @Override
    public List<Department> queryByIsDelete(int isDelete) throws Exception {
        try{
            if (Assert.isNull(isDelete)){
                return null;
            }
            return departmentMapper.queryByIsDelete(isDelete);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.QueryDepartmentByIsDeleteFailed);
        }
    }

    @Override
    public List<Department> listAll() throws Exception {
       try{
            return departmentMapper.listAll();
       }catch (Exception e){
           LogClerk.errLog.error(e);
           throw SSException.get(ChException.ListAllDepartmentFailed);
       }
    }

    @Override
    public List<Integer> queryId() throws SSException {
        return departmentMapper.queryId();
    }
}
