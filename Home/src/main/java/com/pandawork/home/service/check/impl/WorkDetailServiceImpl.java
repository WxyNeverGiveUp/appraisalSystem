package com.pandawork.home.service.check.impl;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.core.common.log.LogClerk;
import com.pandawork.core.common.util.Assert;
import com.pandawork.home.common.entity.check.WorkDetail;
import com.pandawork.home.common.exception.ChException;
import com.pandawork.home.mapper.check.WorkDetailMapper;
import com.pandawork.home.service.check.WorkDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Taoyongpan on 2017/8/30.
 */
@Service(value = "wordDetailServiceImpl")
public class WorkDetailServiceImpl implements WorkDetailService {
    @Autowired
    WorkDetailMapper workDetailMapper;
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SSException.class,Exception.class, RuntimeException.class})
    public void addWorkDetail(WorkDetail workDetail) throws SSException {
        try{
            if (Assert.isNull(workDetail)){
                return;
            }
            workDetailMapper.addWorkDetail(workDetail);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.AddWorkDetailFailed);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SSException.class,Exception.class, RuntimeException.class})
    public void updateWorkDetail(WorkDetail workDetail) throws SSException {
        try{
            if (Assert.isNull(workDetail)){
                return;
            }
            workDetailMapper.updateWorkDetail(workDetail);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.UpdateWorkDetailFailed);
        }

    }

    @Override
    public List<WorkDetail> queryByWId(int wid) throws SSException {
        try{
            if (Assert.isNull(wid)){
                return null;
            }
            return workDetailMapper.queryByWId(wid);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.QueryWorkDetailByWidFailed);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SSException.class,Exception.class, RuntimeException.class})
    public boolean delWorkDetail(int id) throws SSException {
        try{
            if (Assert.isNull(id)){
                return false;
            }
            return workDetailMapper.delWorkDetail(id);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.DelWorkDetailFailed);
        }
    }

    @Override
    public WorkDetail queryById(int id) throws SSException {
        try {
            if (Assert.isNull(id)){
                return null;
            }
            return workDetailMapper.queryById(id);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.QueryWorkDetailByWidFailed);
        }
    }

    @Override
    public List<WorkDetail> queryByUidAndWid(int uid, int wid) throws SSException {
        try {
            if (Assert.isNull(uid)||Assert.isNull(wid)){
                return null;
            }
            return workDetailMapper.queryByUidAndWid(uid,wid);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.QueryWorkDetailByWidFailed);
        }
    }

    @Override
    public void marking(WorkDetail workDetail) throws SSException {
        try {
            if (Assert.isNull(workDetail)){
                return;
            }
            workDetailMapper.marking(workDetail);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.UpdateWorkDetailFailed);
        }
    }

    @Override
    public void addWorkCompletion(WorkDetail workDetail) throws SSException {
        try {
            if (Assert.isNull(workDetail)){
                return;
            }
            workDetailMapper.addWorkCompletion(workDetail);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.AddWorkDetailFailed);
        }
    }
}
