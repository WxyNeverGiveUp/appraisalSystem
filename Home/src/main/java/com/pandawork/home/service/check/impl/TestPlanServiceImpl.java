package com.pandawork.home.service.check.impl;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.core.common.log.LogClerk;
import com.pandawork.core.common.util.Assert;
import com.pandawork.home.common.dto.AllotDto;
import com.pandawork.home.common.entity.check.TestPlan;
import com.pandawork.home.common.exception.ChException;
import com.pandawork.home.mapper.check.TestPlanMapper;
import com.pandawork.home.service.check.TestPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Taoyongpan on 2017/8/28.
 */
@Service(value = "testPlanService")

public class TestPlanServiceImpl implements TestPlanService {

    @Autowired
    TestPlanMapper testPlanMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SSException.class,Exception.class, RuntimeException.class})
    public void addTestPlan(TestPlan testPlan) throws SSException {
        try{
            if (Assert.isNull(testPlan)){
                return;
            }
            testPlanMapper.addTestPlan(testPlan);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.AddTestPlanFailed);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SSException.class,Exception.class, RuntimeException.class})
    public void updateTestPlan(TestPlan testPlan) throws SSException {
        try{
            if (Assert.isNull(testPlan)){
                return;
            }
            testPlanMapper.updateTestPlan(testPlan);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.UpdatePlanFailed);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SSException.class,Exception.class, RuntimeException.class})
    public void delTestPlan(TestPlan testPlan) throws SSException {
        try{
            if (Assert.isNull(testPlan)){
                return;
            }
            testPlanMapper.delTestPlan(testPlan);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.DelPlanFailed);
        }
    }

    @Override
    public TestPlan queryTestPlan(int id) throws SSException {
        try{
            if (Assert.isNull(id)){
                return null;
            }
            return testPlanMapper.queryById(id);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.QueryPlanFailed);
        }
    }

    @Override
    public List<TestPlan> listAll() throws SSException {
        try{
            return testPlanMapper.listAll();
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.ListTestPlanFailed);
        }
    }

    @Override
    public int countAll() throws SSException {
        try{
            return testPlanMapper.countAll();
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.CountTestPlanFailed);
        }
    }

    @Override
    public List<TestPlan> queryByUid(int uid) throws SSException {
        try{
            if (Assert.isNull(uid)){
                return null;
            }
            return testPlanMapper.queryByUid(uid);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.QueryTestPlanByUidFailed);
        }
    }

    @Override
    public List<TestPlan> queryByDid(int did) throws SSException {
        try {
            if (Assert.isNull(did)){
                return null;
            }
            return testPlanMapper.queryByDid(did);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.QueryTestPlanByUidFailed);
        }
    }

    @Override
    public List<TestPlan> queryByUidAndTypeId(int uid, int testTypeId) throws SSException {
        try {
            if (Assert.isNull(uid)||Assert.isNull(testTypeId)){
                return null;
            }
            return testPlanMapper.queryByUidAndTypeId(uid,testTypeId);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.QueryTestPlanByUidFailed);
        }
    }

    @Override
    public List<TestPlan> queryByTypeId(int testTypeId) throws SSException {
        try {
            if (Assert.isNull(testTypeId)){
                return null;
            }
            return testPlanMapper.queryByTypeId(testTypeId);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.QueryTestPlanByUidFailed);
        }
    }

    @Override
    public List<AllotDto> listAllUser() throws SSException {
        return testPlanMapper.listAllUser();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SSException.class,Exception.class, RuntimeException.class})
    public boolean del(int id) throws SSException {
        if (Assert.isNull(id)){
            return false;
        }
        return testPlanMapper.del(id);
    }

    @Override
    public List<AllotDto> queryAllotDaoByDid(int did) throws SSException {
        try {
            if (Assert.isNull(did)){
                return null;
            }
            return testPlanMapper.queryAllotDaoByDid(did);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.QueryAllotByUidFailed);
        }
    }
}
