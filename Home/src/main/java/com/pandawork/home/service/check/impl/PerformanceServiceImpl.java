package com.pandawork.home.service.check.impl;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.core.common.log.LogClerk;
import com.pandawork.core.common.util.Assert;
import com.pandawork.home.common.entity.check.Performance;
import com.pandawork.home.common.exception.ChException;
import com.pandawork.home.mapper.check.PerformanceMapper;
import com.pandawork.home.service.check.PerformanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Taoyongpan on 2017/8/30.
 */
@Service(value = "performanceService")
public class PerformanceServiceImpl implements PerformanceService {
    @Autowired
    PerformanceMapper performanceMapper;
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SSException.class,Exception.class, RuntimeException.class})
    public void addPerformance(Performance performance) throws SSException {
        try{
            if (Assert.isNull(performance)){
                return;
            }
            performanceMapper.addPerformance(performance);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.AddPerformanceFailed);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SSException.class,Exception.class, RuntimeException.class})
    public void updateSummaryScore(Performance performance) throws SSException {
        try{
            if (Assert.isNull(performance)){
                return;
            }
            performanceMapper.updateSummaryScore(performance);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.UpdateSummaryScoreFailed);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SSException.class,Exception.class, RuntimeException.class})
    public void updateYearScore(Performance performance) throws SSException {
        try{
            if (Assert.isNull(performance)){
                return;
            }
            performanceMapper.updateYearScore(performance);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.UpdateYearScore);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SSException.class,Exception.class, RuntimeException.class})
    public boolean delPerformance(int id) throws SSException {
        try{
            if (Assert.isNull(id)){
                return false;
            }
            return performanceMapper.delPerformance(id);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.DelPerformance);
        }
    }

    @Override
    public List<Performance> queryByYearAndMonth(int year, int month) throws SSException {
        try{
            if (Assert.isNull(year)||Assert.isNull(month)){
                return null;
            }
            return performanceMapper.queryByYearAndMonth(year,month);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.QueryPerformanceByYAM);
        }
    }

    @Override
    public List<Performance> queryByYearAndQueater(int year, int queater) throws SSException {
        try{
            if (Assert.isNull(year)||Assert.isNull(queater)){
                return null;
            }
            return performanceMapper.queryByYearAndQueater(year,queater);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.QueryPerformanceByYAQ);
        }
    }

    @Override
    public int countAll() throws SSException {
        try{
            return performanceMapper.countAll();
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.CountAllPerformance);
        }
    }

    @Override
    public List<Performance> queryByDid(int did) throws SSException {
        try{
            if (Assert.isNull(did)){
                return null;
            }
            return performanceMapper.queryByDid(did);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.QueryPerformanceByDid);
        }
    }

    @Override
    public List<Performance> queryByUid(int beCheckId) throws SSException {
        try {
            if (Assert.isNull(beCheckId)){
                return null;
            }
            return performanceMapper.queryByUid(beCheckId);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.QueryPerformanceByDid);
        }
    }

    @Override
    public List<Performance> queryYearByUid(int beCheckId) throws SSException {
        try {
            if (Assert.isNull(beCheckId)){
                return null;
            }
            return performanceMapper.queryYearByUid(beCheckId);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.QueryPerformanceByDid);
        }
    }

    @Override
    public List<Performance> listAll() throws SSException {
        return performanceMapper.listAll();
    }

    @Override
    public Performance queryByUidAndYear(int beCheckId, int year) throws SSException {
        try {
            if (Assert.isNull(beCheckId)||Assert.isNull(year)){
                return null;
            }
            return performanceMapper.queryByUidAndYear(beCheckId,year);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.QueryPerformanceByDid);
        }
    }

    @Override
    public List<Performance> queryByYear(int year) throws SSException {
        try {
            if (Assert.isNull(year)){
                return null;
            }
            return performanceMapper.queryByYear(year);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.QueryPerformanceByYAM);
        }

    }
}
