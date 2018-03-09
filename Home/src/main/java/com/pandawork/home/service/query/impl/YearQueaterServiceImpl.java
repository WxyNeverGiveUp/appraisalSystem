package com.pandawork.home.service.query.impl;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.core.common.log.LogClerk;
import com.pandawork.core.common.util.Assert;
import com.pandawork.home.common.dto.YearQueaterExportDto;
import com.pandawork.home.common.exception.ChException;
import com.pandawork.home.mapper.query.YearQueaterMapper;
import com.pandawork.home.service.query.YearQueaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Taoyongpan on 2017/9/17.
 */
@Service(value = "yearQueaterService")
public class YearQueaterServiceImpl implements YearQueaterService {
    @Autowired
    YearQueaterMapper yearQueaterMapper;

    @Override
    public List<YearQueaterExportDto> listAll() throws SSException {
        return yearQueaterMapper.listAll();
    }

    @Override
    public List<YearQueaterExportDto> queryDtoByConditions(int did, int rid, int year, String username) throws SSException {
        try {
            return yearQueaterMapper.queryDtoByConditions(did,rid,year,username);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw  SSException.get(ChException.ExportFailed);
        }
    }

    @Override
    public List<YearQueaterExportDto> queryByUid(int uid) throws SSException {
        try {
            if (Assert.isNull(uid)){
                return null;
            }
            return yearQueaterMapper.queryByUid(uid);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.ExportFailed);
        }
    }

    @Override
    public List<YearQueaterExportDto> queryByDid(int did) throws SSException {
        try {
            if (Assert.isNull(did)){
                return null;
            }
            return yearQueaterMapper.queryByDid(did);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.ExportFailed);
        }
    }

    @Override
    public YearQueaterExportDto queryByUidAndYear(int uid, int year) throws SSException {
        try {
            if (Assert.isNull(uid)||Assert.isNull(year)){
                return null;
            }
            return yearQueaterMapper.queryByUidAndYear(uid, year);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.ExportFailed);
        }
    }
}
