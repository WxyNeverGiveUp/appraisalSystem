package com.pandawork.home.service.check.impl;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.core.common.log.LogClerk;
import com.pandawork.core.common.util.Assert;
import com.pandawork.home.common.entity.check.TestType;
import com.pandawork.home.common.exception.ChException;
import com.pandawork.home.mapper.check.TestTypeMapper;
import com.pandawork.home.service.check.TestTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Taoyongpan on 2017/8/29.
 */
@Service(value = "testTypeService")
public class TestTypeServiceImpl implements TestTypeService {
    @Autowired
    TestTypeMapper testTypeMapper;
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SSException.class,Exception.class, RuntimeException.class})
    public void addTestType(TestType testType) throws SSException {
        try{
            if (Assert.isNull(testType)){
                return;
            }
            testTypeMapper.addTestType(testType);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.AddTestTypeFailed);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SSException.class,Exception.class, RuntimeException.class})
    public boolean delTestType(int id) throws SSException {
        try{
            if (Assert.isNull(id)){
                return false;
            }
            return testTypeMapper.delTestType(id);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.DelTestTypeFailed);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SSException.class,Exception.class, RuntimeException.class})
    public void updateTestType(TestType testType) throws SSException {
        try{
            if (Assert.isNull(testType)){
                return;
            }
            testTypeMapper.updateTestType(testType);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.UpdateTestTypeFailed);
        }
    }

    @Override
    public List<TestType> listAll() throws SSException {
        try{
            return testTypeMapper.listAll();
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.ListAllTestTypeFailed);
        }
    }
}
