package com.pandawork.home.service.check.impl;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.core.common.log.LogClerk;
import com.pandawork.core.common.util.Assert;
import com.pandawork.home.common.dto.AllotDto;
import com.pandawork.home.common.exception.ChException;
import com.pandawork.home.mapper.check.AbilityAllotMapper;
import com.pandawork.home.service.check.AbilityAllotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Taoyongpan on 2017/9/24.
 */
@Service(value = "/abilityAllotService")
public class AbilityAllotServiceImpl implements AbilityAllotService {
    @Autowired
    AbilityAllotMapper abilityAllotMapper;
    @Override
    public List<AllotDto> generalCheck(int did) throws SSException {
        try {
            if (Assert.isNull(did)){
                return null;
            }
            return abilityAllotMapper.generalCheck(did);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.GeneralCheckFailed);
        }
    }

    @Override
    public List<AllotDto> deputyCheck(int did) throws SSException {
        try {
            if (Assert.isNull(did)){
                return null;
            }
            return abilityAllotMapper.deputyCheck(did);
        }catch(Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.DeputyCheckFailed);
        }
    }

    @Override
    public List<AllotDto> dManagerCheck(int did) throws SSException {
        try{
            if (Assert.isNull(did)){
                return null;
            }
            return abilityAllotMapper.dManagerCheck(did);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.DManagerCheckFailed);
        }
    }

    @Override
    public List<AllotDto> topManagerCheck() throws SSException {
        try {
            return abilityAllotMapper.topManagerCheck();
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.DManagerCheckFailed);
        }
    }

    @Override
    public List<AllotDto> deputyManagerCheck(List<Integer> dids) throws SSException {
        try {
            if (Assert.isNull(dids)){
                return null;
            }
            System.out.println(dids);
            return abilityAllotMapper.deputyManagerCheck(dids);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.DManagerCheckFailed);
        }

    }

    @Override
    public AllotDto queryByUid(int uid) throws SSException {
        try {
            if (Assert.isNull(uid)){
                return null;
            }
            return abilityAllotMapper.queryByUid(uid);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.ExportFailed);
        }
    }

    @Override
    public List<AllotDto> queryGeneralByDid(int did) throws SSException {
        try {
            if (Assert.isNull(did)){
                return null;
            }
            return abilityAllotMapper.queryGeneralByDid(did);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.QueryAbilityTestByTidAndUid);
        }
    }

    @Override
    public List<AllotDto> queryDeputyByDid(int did) throws SSException {
        try {
            if (Assert.isNull(did)){
                return null;
            }
            return abilityAllotMapper.queryDeputyByDid(did);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.QueryAbilityTestByTidAndUid);
        }
    }

    @Override
    public List<AllotDto> queryManageByDid(List<Integer> dids) throws SSException {
        try {
            if (Assert.isNull(dids)){
                return null;
            }
            return abilityAllotMapper.queryManageByDid(dids);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.QueryAbilityTestByTidAndUid);
        }
    }

    @Override
    public List<AllotDto> queryDeputyManagerCheck() throws SSException {
        return abilityAllotMapper.queryDeputyManagerCheck();
    }

    @Override
    public List<AllotDto> queryByTopManagerCheck() throws SSException {
        return abilityAllotMapper.queryByTopManagerCheck();
    }
}
