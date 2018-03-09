package com.pandawork.home.service.check.impl;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.core.common.log.LogClerk;
import com.pandawork.core.common.util.Assert;
import com.pandawork.home.common.entity.check.Summary;
import com.pandawork.home.common.exception.ChException;
import com.pandawork.home.mapper.check.SummaryMapper;
import com.pandawork.home.service.check.SummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Taoyongpan on 2017/8/30.
 */
@Service(value = "summaryService")
public class SummaryServiceImpl implements SummaryService {
    @Autowired
    SummaryMapper summaryMapper;

    @Override
    public void addSummary(Summary summary) throws SSException {
        try{
            if (Assert.isNull(summary)){
                return;
            }
            summaryMapper.addSummary(summary);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.AddSummaryFailed);
        }
    }

    @Override
    public void updateSummary(Summary summary) throws SSException {
        try{
            if (Assert.isNull(summary)){
                return;
            }
            summaryMapper.updateSummary(summary);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.UpdateSummaryFailed);
        }
    }

    @Override
    public void updateScore(Summary summary) throws SSException {
        try{
            if (Assert.isNull(summary)){
                return;
            }
            summaryMapper.updateScore(summary);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.UpdateSummaryScoreFailed);
        }
    }

    @Override
    public List<Summary> queryByUser(Summary summary) throws SSException {
        try{
            if (Assert.isNull(summary)){
                return null;
            }
            return summaryMapper.queryByUser(summary);
        }catch (Exception e){
            LogClerk.errLog.error(e);

            throw SSException.get(ChException.QuerySummaryByUserFailed);
        }
    }

    @Override
    public List<Summary> listAll() throws SSException {
        return summaryMapper.listAll();
    }

    @Override
    public Summary queryById(int id) throws SSException {
        try {
            if (Assert.isNull(id)){
                return null;
            }
            return summaryMapper.queryById(id);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.QuerySummaryByUserFailed);
        }
    }

    @Override
    public List<Summary> queryByDid(int did) throws SSException {
        try {
            if (Assert.isNull(did)){
                return null;
            }
            return summaryMapper.queryByDid(did);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.QuerySummaryByUserFailed);
        }
    }

    @Override
    public List<Summary> queryByYear(int year) throws SSException {
        try {
            if (Assert.isNull(year)){
                return null;
            }
            return summaryMapper.queryByYear(year);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.QuerySummaryByUserFailed);
        }
    }

    @Override
    public Summary queryByUidAndYear(int beCheckId, int year) throws SSException {
        try {
            if (Assert.isNull(beCheckId)||Assert.isNull(year)){
                return null;
            }
            return summaryMapper.queryByUidAndYear(beCheckId,year);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.QuerySummaryByUserFailed);
        }
    }
}
